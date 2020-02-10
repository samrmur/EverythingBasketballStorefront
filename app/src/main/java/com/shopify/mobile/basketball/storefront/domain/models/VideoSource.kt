package com.shopify.mobile.basketball.storefront.domain.models

data class VideoSource(
    val format: String,
    val height: Int,
    val width: Int,
    val mimeType: String,
    val url: String
)