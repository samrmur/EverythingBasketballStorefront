package com.shopify.mobile.basketball.storefront.core

import android.app.Application
import toothpick.ktp.KTP
import toothpick.smoothie.module.SmoothieAndroidXActivityModule
import toothpick.smoothie.module.SmoothieApplicationModule

class StorefrontApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KTP.openRootScope()
            .installModules(
                SmoothieApplicationModule(this, ApplicationConstants.SHARED_PREFERENCES_NAME),
                StorefrontModule(applicationContext),
                NetworkModule()
            )
            .inject(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        KTP.openRootScope().release()
    }
}