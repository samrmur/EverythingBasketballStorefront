package com.shopify.mobile.basketball.storefront.product
import com.shopify.mobile.basketball.storefront.ui.ToolbarState
import com.shopify.mobile.basketball.storefront.ui.ViewState

data class ProductViewState(
    val id: String,
    val title: String,
    val price: Double
) : ViewState

data class ProductToolbarState(
    val title: String,
    val canSave: Boolean
) : ToolbarState