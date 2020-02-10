package com.shopify.mobile.basketball.storefront.domain.repository

import com.shopify.mobile.basketball.storefront.domain.models.Image
import com.shopify.mobile.basketball.storefront.domain.models.Media
import com.shopify.mobile.basketball.storefront.domain.repository.resources.PaginatedResource
import com.shopify.mobile.basketball.storefront.domain.repository.resources.Resource
import kotlinx.coroutines.flow.Flow

interface MediaRepository {
    suspend fun getMediaByPage(productId: String, first: Int, after: String?): Flow<PaginatedResource<Media>>
}