package com.shopify.mobile.basketball.storefront.domain.cases

import com.shopify.mobile.basketball.storefront.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductRecommendationsUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun execute(id: String) = productRepository.getById(id)
}