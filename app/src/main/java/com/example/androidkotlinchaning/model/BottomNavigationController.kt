package com.example.androidkotlinchaning.model

import androidx.fragment.app.Fragment

interface BottomNavigationController {
    val fragments: HashMap<Int, Fragment>
    fun add(id: Int, fragment: Fragment)
    fun setCurrentFragment(resId: Int)
    fun getFragment(resId: Int): Fragment?
}