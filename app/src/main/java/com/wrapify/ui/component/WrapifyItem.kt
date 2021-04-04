package com.wrapify.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wrapify.model.wrapify.TopItem
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun WrapifyItem(
    item: TopItem,
    position: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = "${position + 1}.",
                    modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
            }

            CoilImage(
                data = item.images?.first()?.url.orEmpty(),
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = item.title,
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
                item.subtitle?.let { artistName ->
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = artistName,
                        modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
        }
    }
}