package com.shopify.mobile.storefront.domain.pagination

import com.shopify.mobile.storefront.domain.repository.resources.StorefrontError

sealed class PaginationState<Data> {
    data class LoadingPage<Data>(val isFirstPage: Boolean = false) : PaginationState<Data>()
    class PageLoaded<Data> : PaginationState<Data>()
    class PageError<Data>(val error: StorefrontError) : PaginationState<Data>()
}