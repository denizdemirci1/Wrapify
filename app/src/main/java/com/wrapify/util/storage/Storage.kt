package com.wrapify.util.storage

interface Storage {

    fun setString(key: String, value: String?)
    fun getString(key: String): String?

    fun setBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean
}
