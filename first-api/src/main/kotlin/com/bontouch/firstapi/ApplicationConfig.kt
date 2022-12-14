package com.bontouch.firstapi

import java.net.URL

data class ApplicationConfig(
    val secondApiUrl: URL = URL(System.getenv("SECOND_API_URL"))
)
