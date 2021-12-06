package com.example.androidkotlinchaning.utlis

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun<T> just(value: T) : LiveData<T> {
    return MutableLiveData(value)
}

fun validateEmail (email: String) : Boolean {
    return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}