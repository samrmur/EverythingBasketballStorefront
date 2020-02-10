package com.shopify.mobile.basketball.storefront.domain.pagination

import com.shopify.mobile.basketball.storefront.domain.repository.resources.StorefrontError

sealed class PaginatedItemState<Data> {
    data class LoadingPage<Data>(val isFirstPage: Boolean = false) : PaginatedItemState<Data>()
    data class PageLoaded<Data>(val data: List<Data>?, val hasNextPage: Boolean) : PaginatedItemState<Data>()
    data class PageError<Data>(val error: StorefrontError) : PaginatedItemState<Data>()
}