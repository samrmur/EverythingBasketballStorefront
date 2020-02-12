package com.shopify.mobile.storefront.domain.models

data class Money(
    val amount: Double,
    val currencyCode: CurrencyCode
)