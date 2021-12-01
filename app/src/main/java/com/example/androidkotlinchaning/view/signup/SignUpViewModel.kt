package com.example.androidkotlinchaning.view.signup

import androidx.lifecycle.LiveData
import com.example.androidkotlinchaning.BaseViewModel
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.UserManager

class SignUpViewModel(
    private val userManager: UserManager
) : BaseViewModel() {

    fun addUser(user: User): LiveData<Boolean> {
        return userManager.addUser(user)
    }

    fun getUser(): LiveData<List<User>> {
        return userManager.getUsers()
    }

}