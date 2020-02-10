package com.shopify.mobile.basketball.storefront.domain.models

data class ExternalVideo(
    val id: String,
    val embeddedUrl: String,
    override val alt: String?,
    override val contentType: MediaContentType = MediaContentType.EXTERNAL_VIDEO,
    override val previewImage: Image?
) : Media