package com.bontouch.firstapi

import com.bontouch.common.data.ExampleRequest
import com.bontouch.common.data.ExampleResponse
import com.bontouch.common.plugins.configureHealthRoute
import com.bontouch.common.plugins.configureSerialization
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module(
    config: ApplicationConfig = ApplicationConfig()
) {
    configureSerialization()
    configureHealthRoute()

    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json()
        }
    }

    routing {
        get ("/example") {
            val response: ExampleResponse = client.post("${config.secondApiUrl}/example") {
                contentType(ContentType.Application.Json)
                setBody(
                    ExampleRequest(
                        foo = "foo"
                    )
                )
            }.body()

            call.respond(HttpStatusCode.OK, response)
        }
    }
}
