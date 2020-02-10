package com.shopify.mobile.basketball.storefront.domain.repository.apollo

import MediaListQuery
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.shopify.mobile.basketball.storefront.domain.models.Image
import com.shopify.mobile.basketball.storefront.domain.models.Media
import com.shopify.mobile.basketball.storefront.domain.repository.MediaRepository
import com.shopify.mobile.basketball.storefront.domain.repository.resources.PaginatedResource
import com.shopify.mobile.basketball.storefront.domain.repository.resources.Resource
import com.shopify.mobile.basketball.storefront.util.fromApolloToStorefrontError
import com.shopify.mobile.basketball.storefront.util.toDomain
import com.shopify.mobile.basketball.storefront.util.toPaginatedResourceFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ApolloMediaRepository @Inject constructor(private val apolloClient: ApolloClient) : MediaRepository {
    override suspend fun getMediaByPage(productId: String, first: Int, after: String?): Flow<PaginatedResource<Media>> {
        return apolloClient.query(MediaListQuery(id = productId, first = first, after = Input.optional(after))).watcher().toPaginatedResourceFlow(
            after = after,
            exceptionMapper = { it.fromApolloToStorefrontError() },
            hasNextPageExtractor = { it.data()?.node?.asProduct?.media?.pageInfo?.hasNextPage ?: false },
            nextCursorExtractor = { it.data()?.node?.asProduct?.media?.edges?.last()?.cursor },
            responseMapper = { response -> response.data()?.node?.asProduct?.media?.edges?.mapNotNull { it.node.fragments.media.toDomain() } }
        ).flowOn(Dispatchers.IO)
    }
}