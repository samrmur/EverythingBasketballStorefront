package com.shopify.mobile.basketball.storefront.domain.pagination

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import javax.inject.Inject

abstract class PaginationManagerFactory<Model> @Inject constructor(private val paginationManager: PaginationManager<Model>) : DataSource.Factory<String?, Model>() {
    private val _managerProvider = MutableLiveData<PaginationManager<Model>>()
    val managerProvider: LiveData<PaginationManager<Model>>
        get() = _managerProvider

    override fun create(): DataSource<String?, Model> {
        _managerProvider.postValue(paginationManager)
        return paginationManager
    }
}