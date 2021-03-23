package com.wrapify.model.response

data class Album(
    val album_type: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val uri: String
)
