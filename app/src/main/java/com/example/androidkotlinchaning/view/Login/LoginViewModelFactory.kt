package com.example.androidkotlinchaning.view.Login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidkotlinchaning.model.UserManager

class LoginViewModelFactory(
    private val userManager: UserManager
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(
            userManager = userManager
        ) as T
    }
}