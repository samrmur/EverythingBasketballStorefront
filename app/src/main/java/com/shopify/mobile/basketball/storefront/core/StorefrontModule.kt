package com.shopify.mobile.basketball.storefront.core

import android.content.Context
import toothpick.config.Module

class StorefrontModule(context: Context) : Module() {
    init {
        bind(Context::class.java).toInstance(context)
    }
}