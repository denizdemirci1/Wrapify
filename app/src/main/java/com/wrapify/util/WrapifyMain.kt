package com.wrapify.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.wrapify.MainViewModel
import com.wrapify.navigation.Screen
import com.wrapify.ui.home.Home
import com.wrapify.ui.home.util.HomeCategories
import com.wrapify.ui.listing.Listing
import com.wrapify.ui.splash.Splash

@Composable
fun WrapifyMain(
    toggleTheme: () -> Unit,
    mainViewModel: MainViewModel
) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            Splash(navController, mainViewModel)
        }
        composable(Screen.Home.route) {
            Home(navController, HomeCategories.categories, toggleTheme)
        }
        composable(
            "${Screen.Listing.route}/{type}",
            arguments = listOf(navArgument("type") { type = NavType.StringType })
        ) {
            Listing(
                it.arguments?.getString("type").orEmpty()
            )
        }
    }
}