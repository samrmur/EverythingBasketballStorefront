package com.shopify.mobile.basketball.storefront.domain.pagination

class PaginatedArguments : Map<String, Any> {
    val arguments = hashMapOf<String, Any>()

    override val entries: Set<Map.Entry<String, Any>>
        get() = arguments.entries

    override val keys: Set<String>
        get() = arguments.keys

    override val size: Int
        get() = arguments.size

    override val values: Collection<Any>
        get() = arguments.values

    override fun containsKey(key: String): Boolean = arguments.containsKey(key)

    override fun containsValue(value: Any): Boolean = arguments.containsValue(value)

    override fun get(key: String): Any? = arguments[key]

    override fun isEmpty(): Boolean = arguments.isEmpty()

    fun <T> putList(key: String, value: List<T>) {
        arguments[key] = value
    }

    fun putBoolean(key: String, value: Boolean) {
        arguments[key] = value
    }

    fun putInteger(key: String, value: Int){
        arguments[key] = value
    }

    fun putDouble(key: String, value: Double){
        arguments[key] = value
    }

    fun putString(key: String, value: String) {
        arguments[key] = value
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getList(key: String): List<T>? = arguments[key] as? List<T>

    fun getBoolean(key: String): Boolean? = arguments[key] as? Boolean

    fun getInteger(key: String): Int? = arguments[key] as? Int

    fun getDouble(key: String): Double? = arguments[key] as? Double

    fun getString(key: String): String? = arguments[key] as? String
}