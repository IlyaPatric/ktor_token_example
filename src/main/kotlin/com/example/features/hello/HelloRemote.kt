package com.example.features.hello

import kotlinx.serialization.Serializable

@Serializable
data class HelloRequest(
    val token: String
)

@Serializable
data class HelloResponse(
    val login: String
)
