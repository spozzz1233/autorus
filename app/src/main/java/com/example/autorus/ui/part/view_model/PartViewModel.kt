package com.example.autorus.ui.part.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autorus.domain.model.Parts
import com.example.autorus.domain.model.parts
import com.example.autorus.domain.part.PartsInteractor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PartViewModel(
    private val partsInteractor: PartsInteractor
) : ViewModel() {
    private val _partsLivedata = MutableLiveData<List<Parts>>() // Use List instead of ArrayList
    val partsLivedata: LiveData<List<Parts>> = _partsLivedata

    fun getParts() {
        viewModelScope.launch {
            partsInteractor.getParts()
                .collect {
                    processResult(it.data)
                }
        }
    }

    private fun processResult(part: List<Parts>?) {
        val parts = ArrayList<Parts>()
        if (part != null) {
            parts.addAll(part)
            _partsLivedata.value = parts
        }

    }
}
