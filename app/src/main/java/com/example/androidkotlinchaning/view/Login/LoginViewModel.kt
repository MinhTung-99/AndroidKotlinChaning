package com.example.androidkotlinchaning.view.Login

import androidx.lifecycle.LiveData
import com.example.androidkotlinchaning.BaseViewModel
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.UserManager

class LoginViewModel (
    private val userManager: UserManager
) : BaseViewModel() {

    fun getUser(): LiveData<List<User>> {
        return userManager.getUsers()
    }
}