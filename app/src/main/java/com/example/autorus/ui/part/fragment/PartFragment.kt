package com.example.autorus.ui.part.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.autorus.domain.model.Part
import com.example.autorus.domain.model.parts
import com.example.autorus.ui.part.view_model.PartViewModel
import com.example.autorus.util.CartSave
import com.example.playlistmaker.R
import com.example.playlistmaker.databinding.FragmentPartBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class PartFragment : Fragment() {

    private lateinit var binding: FragmentPartBinding
    private lateinit var bottomNavigator: BottomNavigationView
    private lateinit var cartHistory: CartSave
    private val viewModel by viewModel<PartViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val part = arguments?.getParcelable<Part>("part")
        cartHistory = CartSave(requireContext())
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.addCart.setOnClickListener {
            if (part != null) {
                cartHistory.saveCartHistory(part)
            }
            Toast.makeText(requireContext(),"The product has been added to the cart", Toast.LENGTH_SHORT)
                .show()
        }



        if (part != null) {
            binding.partName.text = part.partName
            binding.priceInt.text = part.stockQuantity.toString() + " " + "$"

        }


    }

}