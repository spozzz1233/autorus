package com.example.autorus.data.part

import com.example.autorus.data.network.NetworkClient
import com.example.autorus.data.network.Resource
import com.example.autorus.domain.model.Parts
import kotlinx.coroutines.flow.Flow


interface PartsRepository {
        fun getParts() : Flow<Resource<List<Parts>>>
}