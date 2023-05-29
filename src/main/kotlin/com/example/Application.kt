package com.example

import com.example.features.hello.configureHelloRouting
import com.example.features.img.configureMemeRouting
import com.example.features.login.configureLoginRouting
import com.example.features.register.configureRegisterRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.jetbrains.exposed.sql.Database

fun main() {
    Database.connect(
        url = "jdbc:postgresql://db.dtxeadfmwgphpbhonagq.supabase.co:5432/postgres",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "SCvwVFFHNaIOvgQK"
    )

    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
    configureLoginRouting()
    configureRegisterRouting()
    configureHelloRouting()
    configureMemeRouting()
}
