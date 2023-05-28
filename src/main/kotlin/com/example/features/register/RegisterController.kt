package com.example.features.register

import com.example.database.users.User
import com.example.database.users.UserDTO
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.util.UUID

class RegisterController(private val call: ApplicationCall) {

    suspend fun registerNewUser() {
        val user = call.receive<RegisterRequest>()

        val userDTO = User.fetchUser(user.login)
        if (userDTO != null) {
            call.respond(HttpStatusCode.Conflict, "User is already exists")
        } else {
            val token = UUID.randomUUID().toString()
            User.insert(UserDTO(
                login = user.login,
                password = user.password,
                token = token
            ))
            call.respond(RegisterResponse(token = token))
        }
    }
}