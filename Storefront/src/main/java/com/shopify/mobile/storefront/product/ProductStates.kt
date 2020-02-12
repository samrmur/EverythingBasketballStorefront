package com.shopify.mobile.storefront.product
import com.shopify.mobile.storefront.ui.ToolbarState
import com.shopify.mobile.storefront.ui.ViewState

data class ProductViewState(
    val id: String,
    val title: String,
    val price: Double
) : ViewState

data class ProductToolbarState(
    val title: String,
    val canSave: Boolean
) : ToolbarState