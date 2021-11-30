package com.example.androidkotlinchaning.view.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidkotlinchaning.BaseViewModel
import com.example.androidkotlinchaning.model.User

class SignUpViewModel : BaseViewModel() {

    var userLiveData : MutableLiveData<User> = MutableLiveData()

    fun register (user: User) {
        userLiveData.postValue(user)
    }

    fun getUserRegis () : MutableLiveData<User> {
        return userLiveData
    }

}