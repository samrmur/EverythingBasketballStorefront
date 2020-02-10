package com.shopify.mobile.basketball.storefront.domain.pagination

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shopify.mobile.basketball.storefront.domain.repository.resources.PaginatedResource
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

/**
 * Simple Paginator that works on top of Storefront API definition
 *
 * @author Samer Alabi
 */
abstract class Paginator<Data> : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Default + SupervisorJob()

    private var lastCursor: String? = null
    private var nextCursor: String? = null
    private val _paginatedData = MutableLiveData<HashMap<String?, PaginatedItemState<Data>>>(hashMapOf())
    val paginatedData: LiveData<HashMap<String?, PaginatedItemState<Data>>>
        get() = _paginatedData

    private val currentPaginatedData: HashMap<String?, PaginatedItemState<Data>>
        get() = _paginatedData.value ?: throw IllegalStateException("Not Initialized!")

    protected abstract suspend fun get(cursor: String?): Flow<PaginatedResource<Data>>

    /**
     * Tries to get the next page as long another one is not loading
     */
    fun execute() {
        if (currentPaginatedData[lastCursor] is PaginatedItemState.LoadingPage) return

        launch {
            lastCursor = nextCursor

            get(nextCursor).collect { resource ->
                when (resource) {
                    is PaginatedResource.Loading -> postUpdatedInfo(resource.onCursor, PaginatedItemState.LoadingPage(isFirstPage = resource.onCursor == null))
                    is PaginatedResource.Successful -> {
                        nextCursor = resource.nextCursor
                        postUpdatedInfo(resource.onCursor, PaginatedItemState.PageLoaded(data = resource.data, hasNextPage = resource.hasNextPage))
                    }
                    is PaginatedResource.Failed -> postUpdatedInfo(resource.onCursor, PaginatedItemState.PageError(error = resource.error))
                }
            }
        }
    }

    fun reset() {
        lastCursor = null
        nextCursor = null
        cancel()
        execute()
    }

    fun cancel() {
        coroutineContext.cancelChildren()
    }

    private fun postUpdatedInfo(cursor: String?, itemState: PaginatedItemState<Data>) {
        val resetOccurred = (itemState as? PaginatedItemState.LoadingPage)?.isFirstPage ?: false
        val mappedData: HashMap<String?, PaginatedItemState<Data>> = if (resetOccurred) hashMapOf() else currentPaginatedData

        mappedData[cursor] = itemState
        _paginatedData.postValue(mappedData)
    }
}