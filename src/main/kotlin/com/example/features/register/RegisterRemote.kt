package com.example.features.register

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val login: String,
    val password: String
)

@Serializable
data class RegisterResponse(
    val token: String
)
