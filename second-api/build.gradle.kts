plugins {
    kotlin("jvm")
    application
}

application {
    mainClass.set("com.bontouch.secondapi.ApplicationKt")
}

dependencies {
    implementation(project(":common"))
    implementation(deps.ktor.server.contentNegotiation)
    implementation(deps.ktor.server.core)
    implementation(deps.ktor.serialization)
    implementation(deps.ktor.server.netty)
    implementation(deps.logback.classic)
    testImplementation(deps.kotlin.test)
    testImplementation(deps.ktor.server.tests)
    testImplementation(deps.ktor.server.testHost)
    testImplementation(deps.ktor.client.contentNegotiation)
}