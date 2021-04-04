package com.wrapify.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.wrapify.MainViewModel
import com.wrapify.R

@Composable
fun Splash(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {
    val isAuthenticated = mainViewModel.isAuthenticated
    if (isAuthenticated.value) {
        navController.navigate("home")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary),
        contentAlignment = Alignment.Center,

        ) {
        Image(painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
    }
}
