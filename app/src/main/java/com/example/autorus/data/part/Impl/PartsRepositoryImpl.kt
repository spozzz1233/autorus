package com.example.autorus.data.part.Impl

import com.example.autorus.data.dto.PartsResponse
import com.example.autorus.data.network.NetworkClient
import com.example.autorus.data.network.Resource
import com.example.autorus.data.part.PartsRepository
import com.example.autorus.domain.model.Part
import com.example.autorus.domain.part.ErrorType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class PartsRepositoryImpl(private val networkClient: NetworkClient) : PartsRepository {
    override fun getParts(): Flow<Resource<List<Part>>> = flow {
        try {
            val response = networkClient.doRequest()
            when (response.resultCode) {
                -1 -> {
                    emit(Resource.Error(ErrorType.CONNECTION_ERROR))
                }
                200 -> {
                    val partsList = (response as PartsResponse).results
                    emit(Resource.Success(partsList))
                }
                else -> {

                }
            }
        } catch (error: Error) {
            throw Exception(error)
        }
    }
}