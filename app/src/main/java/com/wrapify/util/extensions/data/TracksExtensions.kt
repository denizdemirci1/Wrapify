package com.wrapify.util.extensions.data

import com.wrapify.model.response.Track
import com.wrapify.model.wrapify.TopItem

fun List<Track>.toTopItemList(): List<TopItem> {
    val topItems = mutableListOf<TopItem>()
    this.forEach { track ->
        topItems.add(
            TopItem(
                id = track.id,
                images = track.album.images,
                title = track.name,
                subtitle = track.artists.firstOrNull()?.name
            )
        )
    }
    return topItems
}
