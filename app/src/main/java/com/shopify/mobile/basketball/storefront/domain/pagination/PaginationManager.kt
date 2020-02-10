@file:JvmName("PaginatorKt")

package com.shopify.mobile.basketball.storefront.domain.pagination

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.shopify.mobile.basketball.storefront.util.RetryCallback
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class PaginationManager<Model> : PageKeyedDataSource<String?, Model>(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Default + SupervisorJob()

    private val retryCallback = MutableLiveData<RetryCallback>()
    protected val paginationState = MutableLiveData<PaginationState<Model>>()

    init {
        /*
         * Mainly needed to handle Apollo cases where query watcher is still active
         */
        addInvalidatedCallback {
            cancel()
        }
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