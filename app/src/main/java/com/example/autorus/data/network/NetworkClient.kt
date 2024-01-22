package com.example.autorus.data.network

interface NetworkClient {
    suspend fun doRequest(): Response
}