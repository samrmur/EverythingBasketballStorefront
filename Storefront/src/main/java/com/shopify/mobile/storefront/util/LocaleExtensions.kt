package com.shopify.mobile.storefront.util

import android.annotation.TargetApi
import android.content.res.Configuration
import android.os.Build
import java.util.*

@Suppress("deprecation")
fun Configuration.getSystemLocaleLegacy(): Locale? = locale

@TargetApi(Build.VERSION_CODES.N)
fun Configuration.getSystemLocale(): Locale? = locales.get(0)