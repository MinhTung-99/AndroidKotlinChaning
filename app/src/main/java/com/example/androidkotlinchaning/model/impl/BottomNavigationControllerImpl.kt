package com.example.androidkotlinchaning.model.impl

import androidx.fragment.app.Fragment
import com.example.androidkotlinchaning.model.BottomNavigationController
import com.example.androidkotlinchaning.model.Navigator
import com.example.androidkotlinchaning.model.replace

class BottomNavigationControllerImpl(private val navigator: Navigator) :
    BottomNavigationController {
    override val fragments: HashMap<Int, Fragment> = hashMapOf()

    override fun add(id: Int, fragment: Fragment) {
        fragments[id] = fragment
    }

    override fun setCurrentFragment(resId: Int) {
        fragments[resId]?.let { navigator.replace(it) }
    }

    override fun getFragment(resId: Int): Fragment? {
        fragments[resId]?.let { return@let }
        return null
    }
}