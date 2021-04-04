package com.wrapify.util.extensions.data

import com.wrapify.model.response.Artist
import com.wrapify.model.wrapify.TopItem

fun List<Artist>.toTopItemList(): List<TopItem> {
    val topItems = mutableListOf<TopItem>()
    this.forEach { artist ->
        topItems.add(
            TopItem(
                id = artist.id,
                images = artist.images,
                title = artist.name,
                subtitle = null
            )
        )
    }
    return topItems
}
