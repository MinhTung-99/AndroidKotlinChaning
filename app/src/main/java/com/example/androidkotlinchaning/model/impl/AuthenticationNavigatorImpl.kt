package com.example.androidkotlinchaning.model.impl

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.MainActivity
import com.example.androidkotlinchaning.model.AuthenticationNavigator

class AuthenticationNavigatorImpl(override val activity: BaseActivity) : AuthenticationNavigator {
    override val fragments: MutableList<Fragment> = mutableListOf()

    override fun navigateToMain(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
    }
}