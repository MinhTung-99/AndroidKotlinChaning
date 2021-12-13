package com.example.androidkotlinchaning.model.impl

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.R
import com.example.androidkotlinchaning.model.Navigator

class NavigatorImpl(val activity: BaseActivity) : Navigator {
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
}