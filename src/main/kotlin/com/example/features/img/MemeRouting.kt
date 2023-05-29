package com.example.features.img

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://192.168.0.106:8080"

private val meme = listOf(
    MemeResponse(name = "Meme", imgUrl = "$BASE_URL/img/meme.jpg")
)


fun Application.configureMemeRouting() {

    routing {
        get("/meme") {
            call.respond(HttpStatusCode.OK, meme)
        }
    }
}