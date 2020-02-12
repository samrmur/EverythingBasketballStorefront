package com.shopify.mobile.storefront.domain.models

data class ProductOption(
    override val id: String,
    val name: String,
    val values: List<String>
) : Node