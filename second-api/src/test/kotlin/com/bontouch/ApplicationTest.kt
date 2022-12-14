package com.bontouch

import com.bontouch.common.data.ExampleRequest
import com.bontouch.common.data.ExampleResponse
import com.bontouch.secondapi.module
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testHealth() = testApplication {
        application {
            module()
        }
        client.get("/health").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("OK", bodyAsText())
        }
    }

    @Test
    fun testExample() = testApplication {
        application {
            module()
        }

        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        client.post("/example") {
            contentType(ContentType.Application.Json)
            setBody(
                ExampleRequest(
                    foo = "foo"
                )
            )
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals(ExampleResponse(
                bar = "bar"
            ), body())
        }
    }
}