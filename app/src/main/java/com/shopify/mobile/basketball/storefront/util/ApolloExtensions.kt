package com.shopify.mobile.basketball.storefront.util

import com.apollographql.apollo.ApolloQueryWatcher
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toFlow
import com.apollographql.apollo.exception.ApolloException
import com.shopify.mobile.basketball.storefront.domain.repository.resources.PaginatedResource
import com.shopify.mobile.basketball.storefront.domain.repository.resources.Resource
import com.shopify.mobile.basketball.storefront.domain.repository.resources.StorefrontError
import kotlinx.coroutines.flow.*

fun Throwable.fromApolloToStorefrontError(): StorefrontError {
    return when (this) {
        is ApolloException -> StorefrontError.NetworkError
        else -> StorefrontError.GenericError
    }
}


/**
 * Turns a flow of a given type into a paginated resource flow. Useful for turning paginated network
 * response flows into domain flows.
 *
 * @author Samer Alabi
 */
suspend fun <R, T> ApolloQueryWatcher<R>.toPaginatedResourceFlow(
    after: String?,
    responseMapper: (Response<R>) -> List<T>?,
    hasNextPageExtractor: (Response<R>) -> Boolean,
    nextCursorExtractor: (Response<R>) -> String?,
    exceptionMapper: (Throwable) -> StorefrontError
): Flow<PaginatedResource<T>> = flow {
    emit(PaginatedResource.Loading(onCursor = after))

    toFlow().catch { throwable ->
        emit(PaginatedResource.Failed(error = exceptionMapper.invoke(throwable), onCursor = after))
    }.collect { response ->
        val mappedResponse = responseMapper.invoke(response)
        val extractedHasNextPage = hasNextPageExtractor.invoke(response)
        val extractedNextCursor = nextCursorExtractor.invoke(response)

        emit(PaginatedResource.Successful(data = mappedResponse, onCursor = after, hasNextPage = extractedHasNextPage, nextCursor = extractedNextCursor) )
    }
}

/**
 * Turns a flow of a given type into a resource flow. Useful for turning paginated network response
 * flows into domain flows.
 *
 * @author Samer Alabi
 */
suspend fun <T, R> ApolloQueryWatcher<R>.toResourceFlow(
    responseMapper: (Response<R>) -> T?,
    exceptionMapper: (Throwable) -> StorefrontError
): Flow<Resource<T>> = flow {
    emit(Resource.Loading())

    toFlow().catch {
        emit(Resource.Failed(error = exceptionMapper.invoke(it)))
    }.collect {
        emit(Resource.Successful(data = responseMapper.invoke(it)) )
    }
}

