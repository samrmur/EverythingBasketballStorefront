package com.shopify.mobile.storefront.domain.cases

import com.shopify.mobile.storefront.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetSingleProductUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun execute(id: String) = productRepository.getById(id).flowOn(Dispatchers.Default)
}