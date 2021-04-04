package com.wrapify.util

import com.wrapify.util.storage.Storage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserManager @Inject constructor(
    private val storage: Storage
) {

    companion object {
        const val TOKEN = "wrapify.token"
        const val TOKEN_REFRESHED = "wrapify.tokenRefreshed"
    }

    var token: String?
        get() = storage.getString(TOKEN)
        set(value) = storage.setString(TOKEN, value)

    var tokenRefreshed: Boolean
        get() = storage.getBoolean(TOKEN_REFRESHED)
        set(value) = storage.setBoolean(TOKEN_REFRESHED, value)
}
