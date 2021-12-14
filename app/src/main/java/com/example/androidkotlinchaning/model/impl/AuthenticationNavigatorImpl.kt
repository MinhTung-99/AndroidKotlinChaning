package com.example.androidkotlinchaning.model.impl

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.MainActivity
import com.example.androidkotlinchaning.R
import com.example.androidkotlinchaning.model.AuthenticationNavigator

class AuthenticationNavigatorImpl(val activity: BaseActivity) : AuthenticationNavigator {
    override val fragments: MutableList<Fragment> = mutableListOf()

    override fun push(fragment: Fragment) {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, fragment, "tag")
            .addToBackStack(null)
            .commit()

        fragments.add(fragment)
    }

    override fun pop() {
        activity.onBackPressed()
    }

    override fun popToRoot() {
        fragments.first().apply {
            fragments.clear()
            push(this)
        }
    }

    override fun navigateToMain(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent)
    }
}