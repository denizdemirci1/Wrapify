package com.wrapify.data.remote.util

import com.wrapify.BuildConfig
import retrofit2.HttpException

private const val UNAUTHORIZED = 401

fun parseNetworkError(
    e: Exception,
    onAuthError: (() -> Unit)? = null
): String? {
    return when (e) {
        is HttpException -> {
            when (e.code()) {
                UNAUTHORIZED -> {
                    onAuthError?.invoke()
                    null
                }
                else -> {
                    if (BuildConfig.DEBUG) {
                        "Response: ${e.response()} \n Code: ${e.code()} \n Message: ${e.message()}"
                    } else {
                        "Something went wrong :("
                    }
                }
            }
        }

        else -> "Something went wrong :("
    }
}