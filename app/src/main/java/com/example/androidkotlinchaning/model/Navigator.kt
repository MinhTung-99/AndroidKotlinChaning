package com.example.androidkotlinchaning.model

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.R

interface Navigator {
    val activity: BaseActivity
    val idFrameLayout: Int
    val fragments: MutableList<Fragment>
}

fun Navigator.push(fragment: Fragment) {
    activity.supportFragmentManager
        .beginTransaction()
        .replace(idFrameLayout, fragment, "tag")
        .addToBackStack(null)
        .commit()

    fragments.add(fragment)
}

fun Navigator.replace(fragment: Fragment) {
    activity.supportFragmentManager
        .beginTransaction()
        .replace(idFrameLayout, fragment, "tag")
        .addToBackStack(null)
        .commit()
}

fun Navigator.pop() {
    activity.onBackPressed()
}

fun Navigator.popToRoot() {
    fragments.first().apply {
        fragments.clear()
        push(this)
    }
}