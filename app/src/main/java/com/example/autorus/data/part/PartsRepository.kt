package com.example.autorus.data.part

import com.example.autorus.data.network.Resource
import com.example.autorus.domain.model.Part
import kotlinx.coroutines.flow.Flow


interface PartsRepository {
        fun getParts() : Flow<Resource<List<Part>>>
}