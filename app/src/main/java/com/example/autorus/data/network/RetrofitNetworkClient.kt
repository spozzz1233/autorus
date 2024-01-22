package com.example.autorus.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.autorus.data.api.PartsApi
import com.example.autorus.data.dto.PartsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetrofitNetworkClient(
    private val Service: PartsApi,
) : NetworkClient {
    override suspend fun doRequest(): Response {

        return withContext(Dispatchers.IO) {
            val response = PartsResponse(Service.getParts())
            try {
                response.apply { resultCode = 200 }
            } catch (e: Throwable) {
                Response().apply { resultCode = 500 }
            }
        }
    }
}