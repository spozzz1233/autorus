package com.example.autorus.ui.cart.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.autorus.ui.cart.view_model.CartViewModel
import com.example.playlistmaker.databinding.FragmentCartBinding

class CartFragment : Fragment() {


    private lateinit var binding: FragmentCartBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }


}