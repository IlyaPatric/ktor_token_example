package com.example.features.login

import com.example.database.users.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.util.UUID

class LoginController(private val call: ApplicationCall) {

    suspend fun performLogin() {
        val user = call.receive<LoginRequest>()
        val userDTO = User.fetchUser(user.login)

        if (userDTO == null) {
            call.respond(HttpStatusCode.BadRequest, "User not found")
        } else {
            if (userDTO.password == user.password) {
                val token = UUID.randomUUID().toString()
                call.respond(LoginResponse(userDTO.token))
            } else {
                call.respond(HttpStatusCode.BadRequest, "Invalid password")
            }
        }
    }
}