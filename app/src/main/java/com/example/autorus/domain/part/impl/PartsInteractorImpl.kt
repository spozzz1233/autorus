package com.example.autorus.domain.part.impl

import com.example.autorus.data.network.Resource
import com.example.autorus.data.part.PartsRepository
import com.example.autorus.domain.model.Parts
import com.example.autorus.domain.part.PartsInteractor
import kotlinx.coroutines.flow.Flow

class PartsInteractorImpl(private val repository: PartsRepository): PartsInteractor {
    override fun getParts(): Flow<Resource<List<Parts>>> {
        return repository.getParts()
    }
}