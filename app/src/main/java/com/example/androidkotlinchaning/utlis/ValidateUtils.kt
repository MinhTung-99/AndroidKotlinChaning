package com.example.androidkotlinchaning.utlis

import android.text.TextUtils

object ValidateUtils {
    fun isValidateEmail (text: String) : Boolean {
        return !TextUtils.isEmpty(text) && android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches();
    }
}