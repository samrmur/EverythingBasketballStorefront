package com.shopify.mobile.storefront.util

import com.shopify.mobile.storefront.ui.Arguments
import toothpick.Scope
import toothpick.config.Module

/**
 * Installs an arguments class to a given scope. Useful for giving a view model a set
 * of arguments retrieved from a bundle.
 *
 * @author Samer Alabi
 */
inline fun <reified A : Arguments> Scope.installArguments(arguments: A) {
    installModules(Module().apply {
        bind(A::class.java).toInstance(arguments)
    })
}