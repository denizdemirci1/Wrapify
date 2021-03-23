package com.wrapify.model.response

data class Track(
    val album: Album,
    val artists: List<Artist>,
    val id: String,
    val name: String,
    val popularity: Int,
    val uri: String,
)
