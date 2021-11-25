package com.example.androidkotlinchaning

import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment

interface Navigator {
    val fragments: MutableList<Fragment>
    fun push(fragment: Fragment)
    fun pop()
    fun popToRoot()
}

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

class AuthenticationActivity : BaseActivity() {
    var navigator: Navigator = NavigatorImpl(this)
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