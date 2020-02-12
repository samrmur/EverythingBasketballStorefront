package com.shopify.mobile.storefront.ui

data class ScreenState<V : ViewState, T : ToolbarState>(
    val isLoading: Boolean = false,
    val isBlocking: Boolean = false,
    val isRefreshing: Boolean = false,
    val isRefreshable: Boolean = true,
    val hasMorePages: Boolean = false,
    val viewState: V? = null,
    val toolbarState: T
)