package com.example.autorus.domain.part
import com.example.autorus.data.network.Resource
import com.example.autorus.domain.model.Part
import kotlinx.coroutines.flow.Flow

interface PartsInteractor {
    fun getParts() : Flow<Resource<List<Part>>>
}