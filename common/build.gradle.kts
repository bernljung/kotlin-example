plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.7.22"
}

dependencies {
    implementation(deps.ktor.server.contentNegotiation)
    implementation(deps.ktor.server.core)
    implementation(deps.ktor.serialization)
}