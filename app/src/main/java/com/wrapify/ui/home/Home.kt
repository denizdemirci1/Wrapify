package com.wrapify.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.wrapify.util.TopBar

@Composable
fun Home(
    navController: NavHostController,
    categories: List<String>,
    toggleTheme: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        item {
            TopBar(
                onToggle = {
                    toggleTheme()
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(1) {
            categories.forEach { type ->
                ItemTypeCard(
                    type,
                    onItemClicked = { item ->
                        navController.navigate("listing/${item}")
                    }
                )
            }
        }
    }
}

@Composable
fun ItemTypeCard(type: String, onItemClicked: (type: String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = { onItemClicked(type) }),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Row {
            Text(
                text = type,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterVertically),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2
            )
        }
    }
}
