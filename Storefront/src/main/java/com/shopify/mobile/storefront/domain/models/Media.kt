package com.shopify.mobile.storefront.domain.models

interface Media {
    val alt: String?
    val previewImage: Image?
    val contentType: MediaContentType
}