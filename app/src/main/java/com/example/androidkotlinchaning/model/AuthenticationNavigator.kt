package com.example.androidkotlinchaning.model

import android.content.Context
import androidx.fragment.app.Fragment

interface AuthenticationNavigator : Navigator {
    fun navigateToMain(context: Context)
}