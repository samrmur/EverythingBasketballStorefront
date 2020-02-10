package com.shopify.mobile.basketball.storefront.util

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.cache.http.HttpCachePolicy
import com.apollographql.apollo.cache.CacheHeaders
import com.apollographql.apollo.cache.normalized.CacheKey
import com.apollographql.apollo.cache.normalized.CacheKeyResolver
import com.apollographql.apollo.cache.normalized.lru.EvictionPolicy
import com.apollographql.apollo.cache.normalized.lru.LruNormalizedCacheFactory
import com.apollographql.apollo.cache.normalized.sql.ApolloSqlHelper
import com.apollographql.apollo.cache.normalized.sql.SqlNormalizedCacheFactory
import com.shopify.mobile.basketball.storefront.core.ApplicationConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import toothpick.ProvidesSingletonInScope
import type.CustomType
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@ProvidesSingletonInScope
class OkHttpClientProvider : Provider<OkHttpClient> {
    private val okHttpLogger = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    override fun get(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(okHttpLogger)
            .build()
    }
}

@Singleton
@ProvidesSingletonInScope
class RetrofitClientProvider @Inject constructor(private val okHttpClient: OkHttpClient) : Provider<Retrofit> {
    override fun get(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(ApplicationConstants.BASE_URL)
            .build()
    }
}

@Singleton
@ProvidesSingletonInScope
class ApolloClientProvider @Inject constructor(
    private val context: Context,
    private val okHttpClient: OkHttpClient
) : Provider<ApolloClient> {
    /*
     * Lru In-Memory Cache combined with a SQL cache, useful for saving response in an SQL database.
     * Note that the SQL database is cleared when the application is killed unless you pass a name
     * into the SQL Helper.
     */
    private val apolloSqlHelper = ApolloSqlHelper.create(context, null)
    private val sqlCacheFactory = SqlNormalizedCacheFactory(apolloSqlHelper)
    private val memoryCacheFactory = LruNormalizedCacheFactory(EvictionPolicy.builder().maxSizeBytes(10 * 1024.toLong()).build()).chain(sqlCacheFactory)

    private val cacheKeyResolver = object : CacheKeyResolver() {
        override fun fromFieldRecordSet(field: ResponseField, recordSet: MutableMap<String, Any>): CacheKey = formatCacheKey(recordSet["id"] as String?)
        override fun fromFieldArguments(field: ResponseField, variables: Operation.Variables): CacheKey = formatCacheKey(field.resolveArgument("id", variables) as String?)
        private fun formatCacheKey(id: String?) = if (id == null || id.isEmpty()) CacheKey.NO_KEY else CacheKey.from(id)
    }

    private val cacheHeaders = CacheHeaders.builder()
        .addHeader(ApplicationConstants.CONTENT_TYPE_HEADER, ApplicationConstants.CONTENT_TYPE_VALUE)
        .addHeader(ApplicationConstants.ACCESS_TOKEN_HEADER, ApplicationConstants.ACCESS_TOKEN_VALUE)
        .build()

    override fun get(): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(ApplicationConstants.BASE_URL)
            .defaultHttpCachePolicy(HttpCachePolicy.CACHE_FIRST)
            .defaultCacheHeaders(cacheHeaders)
            .normalizedCache(memoryCacheFactory, cacheKeyResolver)
            .addCustomTypeAdapter(CustomType.DATETIME, DateTimeAdapter(context = context))
            .okHttpClient(okHttpClient)
            .build()
    }

}