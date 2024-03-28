package com.youthtech.rhythmify.data.network.api_models

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CookieService {

    @Headers("Content-Type: text/html; charset=utf-8")
    @GET("/")
    suspend fun getCookie(): Response<String>
}