package com.wrapify.model.response

data class TopArtistsResponse(
    val items: List<Artist>,
    val total: Int,
    val limit: Int,
    val offset: Int,
    val previous: String?,
    val href: String,
    val next: String?
)
