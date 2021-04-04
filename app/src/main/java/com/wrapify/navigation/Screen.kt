package com.wrapify.navigation

import androidx.annotation.StringRes
import com.wrapify.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Splash : Screen("splash", R.string.text_splash)
    object Home : Screen("home", R.string.text_home)
    object Listing : Screen("listing", R.string.text_listing)
}