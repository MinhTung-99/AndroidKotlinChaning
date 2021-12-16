package com.example.androidkotlinchaning.model.impl

import android.view.MenuItem
import com.example.androidkotlinchaning.R
import com.example.androidkotlinchaning.model.BottomNavigationController
import com.example.androidkotlinchaning.model.Navigator
import com.example.androidkotlinchaning.model.replace

class BottomNavigationControllerImpl(private val navigator: Navigator) : BottomNavigationController {
    override fun add(item: MenuItem) {
        when (item.itemId) {
            R.id.menu_home -> {
                navigator.replace(navigator.fragments[0])
            }
            R.id.menu_chat -> {
                navigator.replace(navigator.fragments[1])
            }
            R.id.menu_notify -> {
                navigator.replace(navigator.fragments[2])
            }
            R.id.menu_profile -> {
                navigator.replace(navigator.fragments[3])
            }
        }
    }

}