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
    fun addUser(name: String, email: String, password: String): LiveData<Boolean> {
        if (email.validateEmail()) {
            val user = getUser().value?.size?.let { User(it, name, email, password) }
            user?.let {
                return userManager.addUser(it, UserManager.InsertPolicy.IGNORE)
            }
        }

        return just(false)
    }

    fun getUser(): LiveData<List<User>> {
        return userManager.getUsers()
    }

}