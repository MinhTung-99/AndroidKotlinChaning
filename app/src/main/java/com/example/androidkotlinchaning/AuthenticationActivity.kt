package com.example.androidkotlinchaning

import android.os.Bundle
import com.example.androidkotlinchaning.model.AuthenticationNavigator
import com.example.androidkotlinchaning.model.Navigator
import com.example.androidkotlinchaning.model.impl.AuthenticationNavigatorImpl
import com.example.androidkotlinchaning.model.impl.NavigatorImpl
import com.example.androidkotlinchaning.view.Login.LoginFragment

class AuthenticationActivity : BaseActivity() {

    var navigator: AuthenticationNavigator = AuthenticationNavigatorImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        navigator.push(LoginFragment())
    }

    override fun onBackPressed() {
        if (navigator.fragments.size == 1) {
            finish()
        } else {
            super.onBackPressed()
        }

        navigator.fragments.removeLast()
    }
}