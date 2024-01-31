package com.example.autorus.ui.cart.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.autorus.domain.model.cart
import com.example.autorus.ui.cart.CartAdapter
import com.example.autorus.ui.cart.view_model.CartViewModel
import com.example.autorus.ui.home.adapter.HomeAdapter
import com.example.autorus.util.CartSave
import com.example.playlistmaker.R
import com.example.playlistmaker.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var cartHistory: CartSave
    private lateinit var binding: FragmentCartBinding
    private lateinit var cartAdapter: CartAdapter
    private var totalCost: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartHistory = CartSave(requireContext())
        cartHistory.getHistoryCart()
        initial()
        checkCart()
        calculateTotalPrice()
        binding.clear.setOnClickListener {
            cartHistory.clearSharedPreferences()
            cartAdapter.updateData()
            checkCart()
        }
        binding.buttonPlaceholder.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_cart_to_navigation_home)
        }


    }
    private fun initial() {
        cartAdapter = CartAdapter(clickListener = { part ->
            val bundle = Bundle()
            bundle.putParcelable("part", part)
            findNavController().navigate(R.id.action_navigation_cart_to_partFragment, bundle)
        })
        binding.recyclerViewHome.adapter = cartAdapter

    }
    fun checkCart(){
        if(cart.isEmpty()){
            binding.buttonPlaceholder.visibility = View.VISIBLE
            binding.placeholder.visibility = View.VISIBLE
            binding.textView2.visibility = View.GONE
            binding.price.visibility = View.GONE
            binding.clear.visibility = View.GONE
            binding.recyclerViewHome.visibility = View.GONE
        }else{
            binding.buttonPlaceholder.visibility = View.GONE
            binding.placeholder.visibility = View.GONE
            binding.textView2.visibility = View.VISIBLE
            binding.price.visibility = View.VISIBLE
            binding.clear.visibility = View.VISIBLE
            binding.recyclerViewHome.visibility = View.VISIBLE
        }
    }
    @SuppressLint("SetTextI18n")
    fun calculateTotalPrice(){
        cart.forEach{
            totalCost += it.stockQuantity
        }
        binding.price.text = "${totalCost.toString()} $"
    }


}