package com.example.practice.ui.etc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practice.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
}