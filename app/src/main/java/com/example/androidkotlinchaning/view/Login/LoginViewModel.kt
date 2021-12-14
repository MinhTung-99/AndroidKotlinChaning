package com.example.androidkotlinchaning.view.Login

import androidx.lifecycle.LiveData
import com.example.androidkotlinchaning.BaseViewModel
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.UserManager
import com.example.androidkotlinchaning.utlis.just

class LoginViewModel (
    private val userManager: UserManager
) : BaseViewModel() {

    fun getUser(): LiveData<List<User>> {
        return userManager.getUsers()
    }

    fun login (email: String, password: String): LiveData<Boolean> {
        getUser().value?.let {
            val count = it.filter { user ->
                user.emailAddress == email && user.password == password
            }.size

            if (count > 0) {
                return just(true)
            }
        }
        return just(false)
    }
}