package com.shopify.mobile.basketball.storefront.domain.models

data class Video(
    override val id: String,
    val sources: List<VideoSource>,
    override val alt: String?,
    override val contentType: MediaContentType = MediaContentType.VIDEO,
    override val previewImage: Image?
) : Media, Node