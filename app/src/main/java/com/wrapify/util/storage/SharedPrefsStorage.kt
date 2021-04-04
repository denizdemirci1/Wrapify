package com.wrapify.util.storage

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPrefsStorage @Inject constructor(@ApplicationContext context: Context) : Storage {

    private val sharedPreferences = context
        .getSharedPreferences("Wrapify", Context.MODE_PRIVATE)

    override fun setString(key: String, value: String?) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): String? {
        return if (sharedPreferences.contains(key)) {
            sharedPreferences.getString(key, "")
        } else {
            null
        }
    }

    override fun setBoolean(key: String, value: Boolean) {
        with(sharedPreferences.edit()) {
            putBoolean(key, value)
            apply()
        }
    }

    override fun getBoolean(key: String) = sharedPreferences.getBoolean(key, false)
}
