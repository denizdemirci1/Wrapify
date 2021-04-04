package com.wrapify.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircularLoading() {
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center ) {
        CircularProgressIndicator(
            color = Color.Blue,
            strokeWidth = 4.dp
        )
    }
}