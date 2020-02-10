package com.shopify.mobile.basketball.storefront.domain.models

interface Media {
    val alt: String?
    val previewImage: Image?
    val contentType: MediaContentType
}