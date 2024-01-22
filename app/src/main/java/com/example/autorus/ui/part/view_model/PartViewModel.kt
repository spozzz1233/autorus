package com.example.autorus.ui.part.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autorus.domain.model.Part
import com.example.autorus.domain.part.PartsInteractor
import kotlinx.coroutines.launch

class PartViewModel(
    private val partsInteractor: PartsInteractor
) : ViewModel() {

}
