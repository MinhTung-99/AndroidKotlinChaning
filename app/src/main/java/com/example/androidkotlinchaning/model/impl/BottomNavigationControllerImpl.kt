package com.example.androidkotlinchaning.model.impl

import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.androidkotlinchaning.R
import com.example.androidkotlinchaning.model.BottomNavigationController
import com.example.androidkotlinchaning.model.Navigator
import com.example.androidkotlinchaning.model.replace

class BottomNavigationControllerImpl(private val navigator: Navigator) : BottomNavigationController {
    override val fragments: HashMap<Int, Fragment> = hashMapOf()

    override fun add(id: Int, fragment: Fragment) {
        fragments[id] = fragment
    }

    override fun get(id: Int) {
        fragments[id]?.let { navigator.replace(it) }
    }
}