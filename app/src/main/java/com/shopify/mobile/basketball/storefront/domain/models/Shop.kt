package com.shopify.mobile.basketball.storefront.domain.models

data class Shop(
    val description: String?,
    val moneyFormat: String,
    val name: String,
    val privacyPolicy: ShopPolicy,
    val refundPolicy: ShopPolicy,
    val termsOfService: ShopPolicy
)