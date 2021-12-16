package com.example.androidkotlinchaning.model.impl

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.MainActivity
import com.example.androidkotlinchaning.R
import com.example.androidkotlinchaning.model.Navigator

class NavigatorImpl(override val activity: BaseActivity, override val idFrameLayout: Int) : Navigator {
    override val fragments: MutableList<Fragment> = mutableListOf()
}