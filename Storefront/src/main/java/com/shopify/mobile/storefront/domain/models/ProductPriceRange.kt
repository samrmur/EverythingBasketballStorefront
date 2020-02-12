package com.shopify.mobile.storefront.domain.models

data class ProductPriceRange(
    val minPrice: Money,
    val maxPrice: Money
)