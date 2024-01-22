package com.example.autorus.data.api

import com.example.autorus.domain.model.Part
import retrofit2.http.GET


interface PartsApi {
    @GET("/api/Parts")
    suspend fun getParts(): List<Part>
}
