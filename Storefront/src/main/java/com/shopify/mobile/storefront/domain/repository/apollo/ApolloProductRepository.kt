package com.shopify.mobile.storefront.domain.repository.apollo

import ProductListQuery
import ProductRecommendationsQuery
import SingleProductQuery
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.shopify.mobile.storefront.domain.models.Product
import com.shopify.mobile.storefront.domain.repository.resources.PaginatedResource
import com.shopify.mobile.storefront.domain.repository.ProductRepository
import com.shopify.mobile.storefront.domain.repository.resources.Resource
import com.shopify.mobile.storefront.util.fromApolloToStorefrontError
import com.shopify.mobile.storefront.util.toDomain
import com.shopify.mobile.storefront.util.toPaginatedResourceFlow
import com.shopify.mobile.storefront.util.toResourceFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ApolloProductRepository @Inject constructor(private val apolloClient: ApolloClient) : ProductRepository {
    override suspend fun getByPage(first: Int, after: String?): Flow<PaginatedResource<Product>> {
        return apolloClient.query(ProductListQuery(first = first, after = Input.optional(after))).watcher().toPaginatedResourceFlow(
            after = after,
            exceptionMapper = { it.fromApolloToStorefrontError() },
            nextCursorExtractor = { it.data()?.products?.edges?.last()?.cursor },
            hasNextPageExtractor = { it.data()?.products?.pageInfo?.hasNextPage ?: false },
            responseMapper = { it.data()?.toDomain() }
        ).flowOn(Dispatchers.IO)
    }

    override suspend fun getById(id: String): Flow<Resource<Product>> {
        return apolloClient.query(SingleProductQuery(id = id)).watcher().toResourceFlow(
            responseMapper = { it.data()?.toDomain() },
            exceptionMapper = { it.fromApolloToStorefrontError() }
        ).flowOn(Dispatchers.IO)
    }

    override suspend fun getRecommendations(id: String): Flow<Resource<List<Product>>> {
        return apolloClient.query(ProductRecommendationsQuery(id = id)).watcher().toResourceFlow(
            responseMapper = { it.data()?.toDomain() },
            exceptionMapper = { it.fromApolloToStorefrontError() }
        ).flowOn(Dispatchers.IO)
    }
}