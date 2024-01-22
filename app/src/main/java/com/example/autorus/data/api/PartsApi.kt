package com.example.autorus.data.api

import com.example.autorus.data.dto.PartsResponse
import retrofit2.http.GET


interface PartsApi {
    @GET("/api/Parts")
    suspend fun getParts(): PartsResponse
}