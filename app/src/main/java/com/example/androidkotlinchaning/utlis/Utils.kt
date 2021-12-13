package com.example.androidkotlinchaning.utlis

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun<T> just(value: T) : LiveData<T> {
    return MutableLiveData(value)
}

fun validateEmail (email: String) : Boolean {
    return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun handleDelay (milliSecond: Long, callback: ()->Unit) {
    Handler(Looper.getMainLooper()).postDelayed({
        callback()
    }, milliSecond)
}

fun showToast (context: Context ,message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}