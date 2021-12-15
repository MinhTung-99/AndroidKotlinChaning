package com.example.androidkotlinchaning.view.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidkotlinchaning.model.UserManager

class SignUpViewModelFactory (
    private val userManager: UserManager
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel(
            userManager = userManager
        ) as T
    }
}