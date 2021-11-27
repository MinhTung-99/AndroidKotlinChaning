package com.example.androidkotlinchaning.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidkotlinchaning.model.User

class SignUpViewModel : ViewModel() {

    var userLiveData : MutableLiveData<User> = MutableLiveData()
    lateinit var viewModel: SignUpViewModel

    fun register (user: User) {
        userLiveData.postValue(user)
    }

    fun getUserRegis () : MutableLiveData<User> {
        return userLiveData
    }

}