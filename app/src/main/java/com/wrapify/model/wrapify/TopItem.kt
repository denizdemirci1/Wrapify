package com.wrapify.model.wrapify

import com.wrapify.model.response.Image

data class TopItem(
    val id: String,
    val images: List<Image>?,
    val title: String,
    val subtitle: String?
)
