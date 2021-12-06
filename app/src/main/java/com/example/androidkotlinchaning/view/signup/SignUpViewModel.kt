package com.example.androidkotlinchaning.view.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidkotlinchaning.BaseViewModel
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.UserManager
import com.example.androidkotlinchaning.utlis.just
import com.example.androidkotlinchaning.utlis.validateEmail

class SignUpViewModel(
    private val userManager: UserManager
) : BaseViewModel() {
    fun addUser(user: User): LiveData<Boolean> {
        if (validateEmail(user.emailAddress)) {
            return userManager.addUser(user, UserManager.InsertPolicy.UPDATE)
        }

        return just(false)
    }

    fun getUser(): LiveData<List<User>> {
        return userManager.getUsers()
    }

}