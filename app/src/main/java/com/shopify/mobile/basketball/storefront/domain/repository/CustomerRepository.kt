package com.shopify.mobile.basketball.storefront.domain.repository

import com.apollographql.apollo.api.Response
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {
    suspend fun getByPage(first: Int, after: String?): Flow<Response<ProductListQuery.Data>>
    suspend fun getById(id: String): Flow<Response<SingleProductQuery.Data>>
    suspend fun getRecommendations(id: String): Flow<Response<ProductRecommendationsQuery.Data>>
}