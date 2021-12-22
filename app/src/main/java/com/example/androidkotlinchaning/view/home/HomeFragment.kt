package com.example.androidkotlinchaning.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidkotlinchaning.BaseFragment
import com.example.androidkotlinchaning.R
import com.example.androidkotlinchaning.adapter.HomeAdapter
import com.example.androidkotlinchaning.databinding.FragmentHomeBinding
import com.example.androidkotlinchaning.model.Home
import com.example.androidkotlinchaning.repository.HomeRepository
import com.example.androidkotlinchaning.repository.remote.HomeRemoteDataSource

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var viewModel: HomeViewModel
    private lateinit var viewModelFactory: HomeViewModelFactory

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

        viewModelFactory = HomeViewModelFactory(HomeRepository(HomeRemoteDataSource()))
        viewModel = viewModelFactory.create(HomeViewModel::class.java)
        homeAdapter = HomeAdapter(mutableListOf())
        binding.rvHome.adapter = homeAdapter

        viewModel.getHomes().observe(requireActivity(), {
            homeAdapter.update(it)
        })
    }
}