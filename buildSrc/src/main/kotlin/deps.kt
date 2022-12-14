object deps {
    object kotlin {
        private const val version = "1.7.22"
        object stdlib {
            const val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        }
        const val test = "org.jetbrains.kotlin:kotlin-test"
    }

    object ktor {
        private const val version = "2.2.1"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json-jvm:$version"
        object server {
            const val contentNegotiation = "io.ktor:ktor-server-content-negotiation:$version"
            const val core = "io.ktor:ktor-server-core-jvm:$version"
            const val netty = "io.ktor:ktor-server-netty-jvm:$version"
            const val tests = "io.ktor:ktor-server-tests-jvm:$version"
            const val testHost = "io.ktor:ktor-server-test-host:$version"
        }

        object client {
            const val core = "io.ktor:ktor-client-core:$version"
            const val engine = "io.ktor:ktor-client-okhttp:$version"
            const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        }
    }

    object logback {
        const val version = "1.2.11"
        const val classic = "ch.qos.logback:logback-classic:$version"
    }
}