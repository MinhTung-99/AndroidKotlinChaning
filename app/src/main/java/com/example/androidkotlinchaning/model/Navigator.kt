package com.example.androidkotlinchaning.model

import androidx.fragment.app.Fragment

interface Navigator {
    val fragments: MutableList<Fragment>
    fun push(fragment: Fragment)
    fun pop()
    fun popToRoot()
}