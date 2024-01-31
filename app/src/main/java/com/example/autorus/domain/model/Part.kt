package com.example.autorus.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Part(
    val id: Int,
    val partName: String,
    val price: Float,
    val stockQuantity: Int
): Parcelable{

}

var parts = listOf<Part>()

var cart = ArrayList<Part>()