package com.example.autorus.util

import android.content.Context
import android.content.SharedPreferences
import com.example.autorus.domain.model.Part
import com.example.autorus.domain.model.cart
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

class CartSave(private val context:Context) {
    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

    fun clearSharedPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences("SaveHistory", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove("history")
        editor.apply()
        cart.clear()
    }
    fun saveCartHistory(part: Part) {
        sharedPreferences = context.getSharedPreferences("SaveHistory", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val existingTrackIndex = cart.indexOfFirst { it.partName == part.partName && it.id == part.id}
        if (existingTrackIndex != -1) {

            val existingTrack = cart.removeAt(existingTrackIndex)
            cart.add(0, existingTrack)
        } else {
            val historyCart = part
            cart.add(0, historyCart)
        }

        if (cart.size >= 10) {
            cart.removeAt(0)
        }

        val updatedJsonHistory = Gson().toJson(cart)
        editor.putString("history", updatedJsonHistory)
        editor.apply()

    }
    fun getHistoryCart() {
        sharedPreferences = context.getSharedPreferences("SaveHistory", Context.MODE_PRIVATE)
        val jsonHistory = sharedPreferences.getString("history", null)
        if (jsonHistory != null) {
            val type = object : TypeToken<ArrayList<Part>>() {}.type
            val loadedTracks: ArrayList<Part> = gson.fromJson(jsonHistory, type)
            cart.clear()
            cart.addAll(loadedTracks)
        }
    }
}