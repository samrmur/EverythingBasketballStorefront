package com.shopify.mobile.storefront.domain.models

data class Product(
    override val id: String,
    val handle: String,
    val title: String,
    val description: String,
    val productType: String,
    val priceRange: ProductPriceRange,
    val availableForSale: Boolean
) : Node

