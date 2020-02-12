package com.shopify.mobile.storefront.domain.repository.resources

sealed class PaginatedResource<T> {
    data class Loading<T>(val onCursor: String?) : PaginatedResource<T>()
    data class Successful<T>(val data: List<T>?, val onCursor: String?, val hasNextPage: Boolean, val nextCursor: String?) : PaginatedResource<T>()
    data class Failed<T>(val onCursor: String?, val error: StorefrontError) : PaginatedResource<T>()
}