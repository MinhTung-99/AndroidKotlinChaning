package com.example.androidkotlinchaning

import android.os.Bundle
import com.example.androidkotlinchaning.databinding.ActivityMainBinding
import com.example.androidkotlinchaning.model.impl.BottomNavigationControllerImpl
import com.example.androidkotlinchaning.model.impl.NavigatorImpl
import com.example.androidkotlinchaning.model.replace
import com.example.androidkotlinchaning.view.chat.ChatFragment
import com.example.androidkotlinchaning.view.home.HomeFragment
import com.example.androidkotlinchaning.view.notify.NotifyFragment
import com.example.androidkotlinchaning.view.personal.ProfileFragment

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navigator = NavigatorImpl(this, R.id.fragment_main)
    private val bottomNavigationController = BottomNavigationControllerImpl(navigator)

    private val homeFragment by lazy { HomeFragment() }
    private val chatFragment by lazy { ChatFragment() }
    private val notifyFragment by lazy { NotifyFragment() }
    private val profileFragment by lazy { ProfileFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.itemIconTintList = null

        navigator.replace(homeFragment)

        addBottomNav()

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            bottomNavigationController.setCurrentFragment(item.itemId)
            return@setOnItemSelectedListener true
        }
    }

    private fun addBottomNav () {
        bottomNavigationController.add(R.id.menu_home, homeFragment)
        bottomNavigationController.add(R.id.menu_chat, chatFragment)
        bottomNavigationController.add(R.id.menu_notify, notifyFragment)
        bottomNavigationController.add(R.id.menu_profile, profileFragment)
    }
}