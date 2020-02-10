package com.shopify.mobile.basketball.storefront.domain.models

data class Model3d(
    override val id: String,
    val sources: List<Model3dSource>,
    override val alt: String?,
    override val previewImage: Image?,
    override val contentType: MediaContentType = MediaContentType.MODEL_3D
) : Media, Node