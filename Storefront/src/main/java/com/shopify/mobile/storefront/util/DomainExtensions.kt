package com.shopify.mobile.storefront.util

import com.shopify.mobile.storefront.domain.models.*
import type.CountryCode as GeneratedCountryCode
import type.CurrencyCode as GeneratedCurrencyCode
import type.MediaContentType as GeneratedMediaContentType
import fragment.Money as GeneratedMoney
import fragment.Media as GeneratedMedia
import fragment.Image as GeneratedImage

fun GeneratedCountryCode.toDomain(): CountryCode = CountryCode.valueOf(this.rawValue)
fun GeneratedCurrencyCode.toDomain(): CurrencyCode = CurrencyCode.valueOf(this.rawValue)

fun ProductRecommendationsQuery.Data.toDomain(): List<Product> = listOf()
fun ProductListQuery.Data.toDomain(): List<Product> = listOf()

fun SingleProductQuery.PriceRange.toDomain(): ProductPriceRange {
    return ProductPriceRange(
        minPrice = minVariantPrice.fragments.money.toDomain(),
        maxPrice = maxVariantPrice.fragments.money.toDomain()
    )
}

fun GeneratedMoney.toDomain(): Money {
    return Money(
        amount = amount,
        currencyCode = currencyCode.toDomain()
    )
}

fun GeneratedImage.toDomain(): Image {
    return Image(
        id = id,
        altText = altText,
        originalSource = originalSrc,
        transformedSource = transformedSrc
    )
}

fun GeneratedMedia.Source.toDomain(): VideoSource {
    return VideoSource(
        url = url,
        mimeType = mimeType,
        format = format,
        width = width,
        height = height
    )
}

fun GeneratedMedia.Source1.toDomain(): Model3dSource {
    return Model3dSource(
        fileSize = filesize,
        format = format,
        mimeType = mimeType,
        url = url
    )
}

fun GeneratedMedia.toDomain(): Media? {
    return when(this.mediaContentType) {
        GeneratedMediaContentType.EXTERNAL_VIDEO -> asExternalVideo?.let { externalVideo ->
            ExternalVideo(
                id = externalVideo.id,
                embeddedUrl = externalVideo.embeddedUrl,
                alt = externalVideo.alt,
                previewImage = externalVideo.previewImage?.fragments?.image?.toDomain()
            )
        }
        GeneratedMediaContentType.VIDEO -> asVideo?.let { video ->
            Video(
                id = video.id,
                alt = video.alt,
                previewImage = video.previewImage?.fragments?.image?.toDomain(),
                sources = video.sources.map { it.toDomain() }
            )
        }
        GeneratedMediaContentType.IMAGE -> asMediaImage?.let { mediaImage ->
            MediaImage(
                id = mediaImage.id,
                alt = mediaImage.alt,
                image = mediaImage.image?.fragments?.image?.toDomain(),
                previewImage = mediaImage.image?.fragments?.image?.toDomain()
            )
        }
        GeneratedMediaContentType.MODEL_3D -> asModel3d?.let { model3d ->
            Model3d(
                id = model3d.id,
                alt = model3d.alt,
                previewImage = model3d.previewImage?.fragments?.image?.toDomain(),
                sources = model3d.sources.map { it.toDomain() }
            )
        }
        else -> null
    }
}

fun SingleProductQuery.Data.toDomain(): Product? {
    return node?.asProduct?.let { product ->
        with (product) {
            Product(
                id = id,
                title = title,
                handle = handle,
                description = description,
                priceRange = priceRange.toDomain(),
                productType = "",
                availableForSale = availableForSale
            )
        }
    }
}
