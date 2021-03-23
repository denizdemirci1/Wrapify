package com.wrapify.model.response

data class Artist(
    val followers: Follower?,
    val genres: List<String>?,
    val id: String,
    val images: List<Image>?,
    val name: String,
    val popularity: Int,
    val uri: String
)

data class Follower(
    val total: Int
)
