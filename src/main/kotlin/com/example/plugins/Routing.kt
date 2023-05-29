package com.example.plugins

import io.ktor.http.ContentDisposition.Companion.File
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import java.io.File

fun Application.configureRouting() {
    
    routing {
        /*get("/") {
            call.respondText("Hello World!")
        }*/

        //staticFiles("/", File("/src/main/resources/static/img"))

        static{
            resources("static")
        }

        // Static plugin. Try to access `/static/index.html`
        /*static("/static") {
            resources("static")
        }*/
    }
}
