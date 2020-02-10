package com.shopify.mobile.basketball.storefront.navigation.subscreens.catalog

import androidx.lifecycle.ViewModel
import com.shopify.mobile.basketball.storefront.domain.pagination.PaginatedArguments
import com.shopify.mobile.basketball.storefront.navigation.subscreens.catalog.CatalogPaginator.Companion.ARG_FIRST

class CatalogViewModel : ViewModel() {
    private val catalogPaginator = CatalogPaginator(arguments = PaginatedArguments().apply {
        putInteger(ARG_FIRST, 15)
    })

    override fun onCleared() {
        super.onCleared()
        catalogPaginator.cancel()
    }
}