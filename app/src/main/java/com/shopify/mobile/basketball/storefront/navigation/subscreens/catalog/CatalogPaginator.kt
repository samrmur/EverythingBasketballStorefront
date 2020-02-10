package com.shopify.mobile.basketball.storefront.navigation.subscreens.catalog

import com.shopify.mobile.basketball.storefront.domain.cases.GetPaginatedProductsUseCase
import com.shopify.mobile.basketball.storefront.domain.models.Product
import com.shopify.mobile.basketball.storefront.domain.pagination.PaginatedArguments
import com.shopify.mobile.basketball.storefront.domain.pagination.Paginator
import com.shopify.mobile.basketball.storefront.domain.repository.resources.PaginatedResource
import kotlinx.coroutines.flow.Flow
import toothpick.ktp.delegate.inject

class CatalogPaginator constructor(private val arguments: PaginatedArguments) : Paginator<Product>() {
    companion object {
        const val ARG_FIRST: String = "ARG_FIRST"
    }

    private val getPaginatedProductsUseCase: GetPaginatedProductsUseCase by inject()

    override suspend fun get(cursor: String?): Flow<PaginatedResource<Product>> {
        val first = arguments.getInteger(ARG_FIRST)

        return first?.let {
            getPaginatedProductsUseCase.execute(first = it, after = cursor)
        } ?: throw IllegalStateException("Please pass in the amount of items you want!")
    }

}