package com.shopify.mobile.storefront.domain.repository

import com.shopify.mobile.storefront.domain.models.Media
import com.shopify.mobile.storefront.domain.repository.resources.PaginatedResource
import kotlinx.coroutines.flow.Flow

interface MediaRepository {
    suspend fun getMediaByPage(productId: String, first: Int, after: String?): Flow<PaginatedResource<Media>>
}