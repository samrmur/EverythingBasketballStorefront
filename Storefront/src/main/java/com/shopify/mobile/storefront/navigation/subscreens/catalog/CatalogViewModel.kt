package com.shopify.mobile.storefront.navigation.subscreens.catalog

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CatalogViewModel @Inject constructor(private val paginationManager: CatalogPaginationManager) : ViewModel() {
    override fun onCleared() {
        super.onCleared()
        paginationManager.invalidate()
    }
}