package com.example.features.img

import kotlinx.serialization.Serializable

@Serializable
data class MemeResponse(
    val name: String,
    val imgUrl: String
)
