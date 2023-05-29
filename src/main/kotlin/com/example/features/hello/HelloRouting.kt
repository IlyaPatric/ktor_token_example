package com.example.features.hello

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureHelloRouting() {

    routing {
        post("/hello") {
            val helloController = HelloController(call)
            helloController.performHello()
        }
    }
}