package com.example.autorus.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Parts(
    val id: Int,
    val partName: Int,
    val price: Float,
    val stockQuantity: Int,
    val imageParts: String
): Parcelable

var parts = ArrayList<Parts>()