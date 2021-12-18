package com.example.androidkotlinchaning.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidkotlinchaning.BaseViewModel
import com.example.androidkotlinchaning.R
import com.example.androidkotlinchaning.model.Home

class HomeViewModel : BaseViewModel() {

    private val mutableLiveData: MutableLiveData<MutableList<Home>> by lazy { MutableLiveData() }

    fun getHomes () : LiveData<MutableList<Home>> {
        addHome()
        return mutableLiveData
    }

    private fun addHome () {
        val homes = mutableListOf<Home>()
        homes.add(Home(1, R.drawable.ic_avatar, "Martin Palmer", "Today, 03:24 PM",
            "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin….",
            R.drawable.ic_content, "$340.00"))
        homes.add(Home(2, R.drawable.ic_avatar, "Martin Palmer", "Today, 03:24 PM",
            "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin….",
            null, "$350.00"))
        homes.add(Home(3, R.drawable.ic_avatar, "Martin Palmer", "Today, 03:24 PM",
            "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin….",
            R.drawable.ic_content, "$360.00"))

        mutableLiveData.postValue(homes)
    }
}