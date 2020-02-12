package com.shopify.mobile.storefront.domain.models

data class ProductVariant(
    override val id: String,
    val title: String,
    val selectedOptions: List<SelectedOption>,
    val price: Money,
    val image: Image?,
    val requiresShipping: Boolean,
    val availableForSale: Boolean,
    val weight: Float?,
    val weightUnit: WeightUnit = WeightUnit.KILOGRAMS
) : Node