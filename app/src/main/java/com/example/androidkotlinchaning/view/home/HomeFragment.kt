package com.example.androidkotlinchaning.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidkotlinchaning.BaseFragment
import com.example.androidkotlinchaning.adapter.HomeAdapter
import com.example.androidkotlinchaning.databinding.FragmentHomeBinding
import com.example.androidkotlinchaning.model.Home

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val homes: MutableList<Home> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homes.clear()
        homes.add(Home(1))
        homes.add(Home(2))
        homeAdapter = HomeAdapter(homes)
        binding.rvHome.adapter = homeAdapter
    }
}