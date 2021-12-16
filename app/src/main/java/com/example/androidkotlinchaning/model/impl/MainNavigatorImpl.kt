package com.example.androidkotlinchaning.model.impl

import androidx.fragment.app.Fragment
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.model.MainNavigator

class MainNavigatorImpl(override val activity: BaseActivity) : MainNavigator {
    override val fragments: MutableList<Fragment> = mutableListOf()
}