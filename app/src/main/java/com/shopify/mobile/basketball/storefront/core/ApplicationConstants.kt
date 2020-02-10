package com.shopify.mobile.basketball.storefront.core

import com.shopify.mobile.basketball.storefront.BuildConfig

object ApplicationConstants {
    const val BASE_URL = BuildConfig.BaseUrl
    const val SHARED_PREFERENCES_NAME = "SHOPIFY:BASKETBALL:STOREFRONT"
    const val ACCESS_TOKEN_HEADER = "X-Shopify-Storefront-Access-Token"
    const val CONTENT_TYPE_HEADER = "Content-Type"
    const val ACCESS_TOKEN_VALUE = BuildConfig.ApiKey
    const val CONTENT_TYPE_VALUE = "application/json"
}