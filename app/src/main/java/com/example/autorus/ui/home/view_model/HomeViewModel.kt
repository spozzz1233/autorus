package com.example.autorus.ui.home.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autorus.domain.model.Part
import com.example.autorus.domain.part.PartsInteractor
import kotlinx.coroutines.launch

class HomeViewModel(
    private val partsInteractor: PartsInteractor
) : ViewModel() {

    private val _partLivedata = MutableLiveData<List<Part>>() // Use List instead of ArrayList
    val partLivedata: LiveData<List<Part>> = _partLivedata

    fun getParts() {
        viewModelScope.launch {
            partsInteractor.getParts()
                .collect {
                    processResult(it.data)
                }
        }
    }

    private fun processResult(part: List<Part>?) {
        val parts = ArrayList<Part>()
        if (part != null) {
            parts.addAll(part)
            _partLivedata.value = parts
        }

    }
}