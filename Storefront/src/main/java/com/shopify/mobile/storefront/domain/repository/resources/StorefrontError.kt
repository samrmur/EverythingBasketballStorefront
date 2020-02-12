package com.shopify.mobile.storefront.domain.repository.resources

sealed class StorefrontError {
    object NetworkError : StorefrontError()
    object GenericError : StorefrontError()
}