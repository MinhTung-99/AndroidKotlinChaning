package com.example.androidkotlinchaning.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidkotlinchaning.repository.HomeRepository

class HomeViewModelFactory (
    private val homeRepository: HomeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(
            homeRepository = homeRepository
        ) as T
    }
}