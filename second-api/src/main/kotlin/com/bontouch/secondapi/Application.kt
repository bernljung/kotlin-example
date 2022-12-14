package com.bontouch.secondapi

import com.bontouch.common.data.ExampleResponse
import com.bontouch.common.plugins.configureHealthRoute
import com.bontouch.common.plugins.configureSerialization
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureHealthRoute()

    routing {
        post("/example") {
            call.respond(
                ExampleResponse(
                    bar = "bar"
                )
            )
        }
    }
}
