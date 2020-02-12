package com.shopify.mobile.storefront.domain.models

data class MediaImage(
    override val id: String,
    val image: Image?,
    override val alt: String?,
    override val previewImage: Image?,
    override val contentType: MediaContentType = MediaContentType.IMAGE
) : Media, Node