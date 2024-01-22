package com.example.autorus.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.autorus.ui.home.adapter.HomeAdapter
import com.example.autorus.ui.home.view_model.HomeViewModel
import com.example.playlistmaker.R
import com.example.playlistmaker.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getParts()
        viewModel.partLivedata.observe(viewLifecycleOwner,{
            homeAdapter.setItems(it)
        })
        initial()
    }
    private fun initial() {
        homeAdapter = HomeAdapter(clickListener = { part ->
            val bundle = Bundle()
            bundle.putParcelable("track", part)
            findNavController().navigate(
                R.id.action_navigation_home_to_partFragment, bundle
            )


        })
        binding.recyclerViewHome.adapter = homeAdapter

    }


}