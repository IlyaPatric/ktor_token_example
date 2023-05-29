package com.example.features.hello

import com.example.database.users.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import kotlinx.serialization.builtins.UIntArraySerializer

class HelloController(private val call: ApplicationCall) {

    suspend fun performHello() {
        val receive = call.receive<HelloRequest>()
        val userDTO = User.selectUserByToken(receive.token)

        if (userDTO == null) {
            call.respond(HttpStatusCode.BadRequest, "User not found by token")
        } else {
            if (userDTO.token == receive.token) {
                call.respond(HelloResponse(userDTO.login))
            }
        }
    }
}