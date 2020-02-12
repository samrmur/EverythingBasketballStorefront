package com.shopify.mobile.storefront.navigation.subscreens.catalog

import com.shopify.mobile.storefront.domain.cases.GetPaginatedProductsUseCase
import com.shopify.mobile.storefront.domain.models.Product
import com.shopify.mobile.storefront.domain.pagination.PaginationManager
import com.shopify.mobile.storefront.domain.repository.resources.PaginatedResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatalogPaginationManager @Inject constructor(private val productsUseCase: GetPaginatedProductsUseCase) : PaginationManager<Product>() {
    override suspend fun getDataFlow(first: Int, after: String?): Flow<PaginatedResource<Product>> = productsUseCase.execute(first = first, after = after)
}