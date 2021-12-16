package com.example.androidkotlinchaning

import android.os.Bundle
import com.example.androidkotlinchaning.databinding.ActivityMainBinding
import com.example.androidkotlinchaning.model.impl.MainNavigatorImpl
import com.example.androidkotlinchaning.model.replace
import com.example.androidkotlinchaning.view.chat.ChatFragment
import com.example.androidkotlinchaning.view.home.HomeFragment
import com.example.androidkotlinchaning.view.notify.NotifyFragment
import com.example.androidkotlinchaning.view.personal.ProfileFragment

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainNavigator = MainNavigatorImpl(this, R.id.fragment_main)
    private val homeFragment by lazy { HomeFragment() }
    private val chatFragment by lazy { ChatFragment() }
    private val notifyFragment by lazy { NotifyFragment() }
    private val profileFragment by lazy { ProfileFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.itemIconTintList = null

        mainNavigator.replace(homeFragment)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    mainNavigator.replace(homeFragment)
                }
                R.id.menu_chat -> {
                    mainNavigator.replace(chatFragment)
                }
                R.id.menu_notify -> {
                    mainNavigator.replace(notifyFragment)
                }
                R.id.menu_profile -> {
                    mainNavigator.replace(profileFragment)
                }
            }

            return@setOnItemSelectedListener true
        }
    }
}