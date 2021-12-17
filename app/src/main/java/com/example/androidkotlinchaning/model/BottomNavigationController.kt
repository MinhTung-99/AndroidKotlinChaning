package com.example.androidkotlinchaning.model

import android.view.MenuItem
import androidx.fragment.app.Fragment

interface BottomNavigationController {
    val fragments: HashMap<Int, Fragment>
    fun add(id: Int, fragment: Fragment)
    fun get(id: Int)
}