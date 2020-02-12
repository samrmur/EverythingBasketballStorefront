package com.shopify.mobile.storefront.domain.repository

import com.shopify.mobile.storefront.domain.models.Product
import com.shopify.mobile.storefront.domain.repository.resources.PaginatedResource
import com.shopify.mobile.storefront.domain.repository.resources.Resource
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getByPage(first: Int, after: String?): Flow<PaginatedResource<Product>>
    suspend fun getById(id: String): Flow<Resource<Product>>
    suspend fun getRecommendations(id: String): Flow<Resource<List<Product>>>
}