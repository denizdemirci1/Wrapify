package com.wrapify.model.response

data class TopTracksResponse(
    val items: List<Track>,
    val limit: Int,
    val next: String?,
    val offset: Int,
    val previous: String?,
    val total: Int
)
