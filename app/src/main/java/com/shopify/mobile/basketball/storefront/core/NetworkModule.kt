package com.shopify.mobile.basketball.storefront.core

import com.apollographql.apollo.ApolloClient
import com.shopify.mobile.basketball.storefront.domain.repository.apollo.ApolloProductRepository
import com.shopify.mobile.basketball.storefront.domain.repository.ProductRepository
import com.shopify.mobile.basketball.storefront.util.ApolloClientProvider
import com.shopify.mobile.basketball.storefront.util.OkHttpClientProvider
import com.shopify.mobile.basketball.storefront.util.RetrofitClientProvider
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import toothpick.config.Module

/**
 * Toothpick module containing all application scoped instances relating to network and response
 * caching logic.
 *
 * @author Samer Alabi
 */
class NetworkModule : Module() {
    init {
        bind(OkHttpClient::class.java).toProvider(OkHttpClientProvider::class.java)
        bind(Retrofit::class.java).toProvider(RetrofitClientProvider::class.java)
        bind(ApolloClient::class.java).toProvider(ApolloClientProvider::class.java)
        bind(ProductRepository::class.java).to(ApolloProductRepository::class.java)
    }
}
