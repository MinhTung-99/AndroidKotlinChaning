package com.example.androidkotlinchaning.utlis

import android.annotation.SuppressLint
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.androidkotlinchaning.model.SharePreferentManager
import com.example.androidkotlinchaning.model.UserManager
import com.example.androidkotlinchaning.model.impl.SharePreferentManagerImpl
import com.example.androidkotlinchaning.model.impl.UserManagerImpl
import com.example.androidkotlinchaning.view.Login.LoginFragment
import com.example.androidkotlinchaning.view.Login.LoginViewModelFactory
import com.example.androidkotlinchaning.view.signup.SignUpFragment
import com.example.androidkotlinchaning.view.signup.SignUpViewModelFactory

@SuppressLint("StaticFieldLeak")
object InjectUtils {
    private lateinit var context: Context

    private val sharePreferentManager: SharePreferentManager by lazy {
        val sharedPref = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        SharePreferentManagerImpl(sharedPref = sharedPref)
    }

    private val userManager: UserManager by lazy {
        UserManagerImpl(sharePreferentManager)
    }

    fun inject (fragment: Fragment) {
        this.context = fragment.requireActivity().applicationContext
        if (fragment is SignUpFragment) {
            fragment.viewModelFactory = SignUpViewModelFactory(userManager)
        } else if (fragment is LoginFragment) {
            fragment.viewModelFactory = LoginViewModelFactory(userManager)
        }
    }
}