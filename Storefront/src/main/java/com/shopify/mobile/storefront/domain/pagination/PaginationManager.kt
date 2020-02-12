@file:JvmName("PaginatorKt")

package com.shopify.mobile.storefront.domain.pagination

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.shopify.mobile.storefront.domain.repository.resources.PaginatedResource
import com.shopify.mobile.storefront.util.RetryCallback
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

abstract class PaginationManager<Model> : PageKeyedDataSource<String?, Model>(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Default + SupervisorJob()

    private val retryCallback = MutableLiveData<RetryCallback>()
    protected val paginationState = MutableLiveData<PaginationState<Model>>()

    init {
        /*
         * Mainly needed to handle Apollo cases where query watchers are still active
         */
        addInvalidatedCallback {
            cancel()
        }
    }

    protected abstract suspend fun getDataFlow(first: Int, after: String?): Flow<PaginatedResource<Model>>

    override fun loadInitial(params: LoadInitialParams<String?>, callback: LoadInitialCallback<String?, Model>) {
        launch {
            getDataFlow(params.requestedLoadSize, null).collect { resource ->
                when (resource) {
                    is PaginatedResource.Loading -> paginationState.postValue(PaginationState.LoadingPage(isFirstPage = true))
                    is PaginatedResource.Successful -> {
                        paginationState.postValue(PaginationState.PageLoaded())
                        callback.onResult(resource.data ?: emptyList(), null, resource.nextCursor)
                        setRetry(null)
                    }
                    is PaginatedResource.Failed -> {
                        paginationState.postValue(PaginationState.PageError(error = resource.error))
                        setRetry { loadInitial(params, callback) }
                    }
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<String?>, callback: LoadCallback<String?, Model>) {
        launch {
            getDataFlow(params.requestedLoadSize, params.key).collect { resource ->
                when (resource) {
                    is PaginatedResource.Loading -> paginationState.postValue(PaginationState.LoadingPage(isFirstPage = false))
                    is PaginatedResource.Successful -> {
                        paginationState.postValue(PaginationState.PageLoaded())
                        callback.onResult(resource.data ?: emptyList(), resource.nextCursor)
                        setRetry(null)
                    }
                    is PaginatedResource.Failed -> {
                        paginationState.postValue(PaginationState.PageError(error = resource.error))
                        setRetry { loadAfter(params, callback) }
                    }
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<String?>, callback: LoadCallback<String?, Model>) {
        // No action required
    }

    /**
     * Attempts to retry fetching data if a callback is available
     */
    fun retry() {
        retryCallback.value?.let { retry ->
            this.launch(coroutineContext) { retry() }
        }
    }

    /**
     * Cancels all paging operations
     */
    fun cancel() {
        coroutineContext.cancelChildren()
    }

    /**
     * Sets the retry action
     * @action Action
     */
    protected fun setRetry(action: RetryCallback?) {
        retryCallback.postValue(action)
    }
}