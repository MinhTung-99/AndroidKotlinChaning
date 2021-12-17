package com.example.androidkotlinchaning.model

import androidx.fragment.app.Fragment
import com.example.androidkotlinchaning.BaseActivity

interface Navigator {
    val activity: BaseActivity
    val containerResId: Int
    val fragments: MutableList<Fragment>
}

fun Navigator.push(fragment: Fragment) {
    activity.supportFragmentManager
        .beginTransaction()
        .replace(containerResId, fragment, "tag")
        .addToBackStack(null)
        .commit()

    fragments.add(fragment)
}

fun Navigator.replace(fragment: Fragment) {
    activity.supportFragmentManager
        .beginTransaction()
        .replace(containerResId, fragment, "tag")
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