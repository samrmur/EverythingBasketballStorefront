package com.shopify.mobile.storefront.domain.repository.resources

sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    data class Successful<T>(val data: T?) : Resource<T>()
    data class Failed<T>(val error: StorefrontError) : Resource<T>()
}