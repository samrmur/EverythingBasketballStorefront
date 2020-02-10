package com.shopify.mobile.basketball.storefront.domain.repository.resources

sealed class StorefrontError {
    object NetworkError : StorefrontError()
    object GenericError : StorefrontError()
}