package com.example.androidkotlinchaning

import android.os.Bundle

class AuthenticationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, LoginFragment(), "tag")
            .addToBackStack(null)
            .commit()
    }
}