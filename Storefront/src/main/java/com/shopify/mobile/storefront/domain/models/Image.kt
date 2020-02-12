package com.shopify.mobile.storefront.domain.models

data class Image(
    val id: String?,
    val altText: String?,
    val originalSource: String,
    val transformedSource: String
)