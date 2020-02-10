package com.shopify.mobile.basketball.storefront.domain.cases

import com.shopify.mobile.basketball.storefront.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPaginatedProductsUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun execute(first: Int, after: String?) = productRepository.getByPage(first = first, after = after).flowOn(Dispatchers.Default)
}