package com.example.autorus.ui.feedbackScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.playlistmaker.R
import com.example.playlistmaker.databinding.FragmentFeedbackScreenBinding
import com.example.playlistmaker.databinding.FragmentHomeBinding


class FeedbackScreenFragment : Fragment() {

    private lateinit var binding: FragmentFeedbackScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedbackScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSubmitFeedback.setOnClickListener{
            binding.editTextFeedback.setText(" ")
            Toast.makeText(requireContext(),"The review has been sent", Toast.LENGTH_SHORT).show()
        }
        binding.back.setOnClickListener{
            findNavController().popBackStack()
        }
    }



}