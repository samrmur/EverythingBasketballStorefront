@file:JvmName("PaginatorKt")

package com.shopify.mobile.storefront.domain.pagination

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.shopify.mobile.storefront.domain.repository.resources.PaginatedResource
import com.shopify.mobile.storefront.util.RetryCallback
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

abstract class PaginationManager<Model> : PageKeyedDataSource<String?, Model>() {
    private val paginatedScope = object : CoroutineScope {
        override val coroutineContext: CoroutineContext = Dispatchers.Default + SupervisorJob()
    }

    private val retryCallback = MutableLiveData<RetryCallback>()
    private val _paginationState = MutableLiveData<PaginationState<Model>>()
    val paginationState: LiveData<PaginationState<Model>>
        get() = _paginationState

    init {
        /*
         * Mainly needed to handle Apollo cases where query watchers are still active
         */
        addInvalidatedCallback {
            paginatedScope.coroutineContext.cancelChildren()
        }
    }

    protected abstract suspend fun getDataFlow(first: Int, after: String?): Flow<PaginatedResource<Model>>

    override fun loadInitial(params: LoadInitialParams<String?>, callback: LoadInitialCallback<String?, Model>) {
        paginatedScope.launch {
            getDataFlow(params.requestedLoadSize, null).collect { resource ->
                when (resource) {
                    is PaginatedResource.Loading -> _paginationState.postValue(PaginationState.LoadingPage(isFirstPage = true))
                    is PaginatedResource.Successful -> {
                        val data = resource.data
                        _paginationState.postValue(PaginationState.PageLoaded())
                        setRetry(null)

                        when {
                            data != null -> callback.onResult(data, null, resource.nextCursor)
                            else -> callback.onError(IllegalStateException("No data returned by resource!"))
                        }
                    }
                    is PaginatedResource.Failed -> {
                        _paginationState.postValue(PaginationState.PageError(error = resource.error))
                        setRetry { loadInitial(params, callback) }
                    }
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<String?>, callback: LoadCallback<String?, Model>) {
        paginatedScope.launch {
            getDataFlow(params.requestedLoadSize, params.key).collect { resource ->
                when (resource) {
                    is PaginatedResource.Loading -> _paginationState.postValue(PaginationState.LoadingPage(isFirstPage = false))
                    is PaginatedResource.Successful -> {
                        val data = resource.data
                        _paginationState.postValue(PaginationState.PageLoaded())
                        setRetry(null)

                        when {
                            data == null -> callback.onError(IllegalStateException("No data returned by resource!"))
                            resource.hasNextPage -> callback.onResult(data, resource.nextCursor)
                        }
                    }
                    is PaginatedResource.Failed -> {
                        _paginationState.postValue(PaginationState.PageError(error = resource.error))
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
            paginatedScope.launch { retry() }
        }
    }

    /**
     * Sets the retry action
     * @action Action
     */
    private fun setRetry(action: RetryCallback?) {
        retryCallback.postValue(action)
    }
}