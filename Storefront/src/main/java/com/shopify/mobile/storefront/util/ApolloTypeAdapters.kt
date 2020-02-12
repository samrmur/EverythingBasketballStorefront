package com.shopify.mobile.storefront.util

import android.content.Context
import com.apollographql.apollo.response.CustomTypeAdapter
import com.apollographql.apollo.response.CustomTypeValue
import java.text.SimpleDateFormat
import java.util.*

class DateTimeAdapter(private val context: Context) : CustomTypeAdapter<Date> {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", getLocale())

    override fun encode(value: Date) = CustomTypeValue.GraphQLString(dateFormat.format(value))
    override fun decode(value: CustomTypeValue<*>): Date = dateFormat.parse(value.value.toString())!!

    private fun getLocale(): Locale? {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            context.resources.configuration.getSystemLocale()
        } else {
            context.resources.configuration.getSystemLocaleLegacy()
        }
    }
}