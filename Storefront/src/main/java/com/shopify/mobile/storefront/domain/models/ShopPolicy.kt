package com.shopify.mobile.storefront.domain.models

data class ShopPolicy(
    override val id: String,
    val handle: String,
    val title: String,
    val body: String,
    val url: String
) : Node