package com.example.autorus.ui.part.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autorus.domain.model.parts
import com.example.autorus.ui.part.view_model.PartViewModel
import com.example.playlistmaker.databinding.FragmentPartBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PartFragment : Fragment() {

    private lateinit var binding: FragmentPartBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}