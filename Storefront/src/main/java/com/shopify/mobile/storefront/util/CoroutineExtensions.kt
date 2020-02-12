package com.shopify.mobile.storefront.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOf

@kotlinx.coroutines.FlowPreview
fun <T> merge(vararg flows: Flow<T>): Flow<T> = flowOf(*flows).flatMapMerge { flow ->
    flow
}