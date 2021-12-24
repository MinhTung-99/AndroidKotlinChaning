package com.example.androidkotlinchaning.repository.remote

import com.example.androidkotlinchaning.R
import com.example.androidkotlinchaning.datasource.HomeDataSource
import com.example.androidkotlinchaning.model.Home

class HomeRemoteDataSource : HomeDataSource {

    override fun getHome() : MutableList<Home> {
        val homes = mutableListOf<Home>()
        homes.add(
            Home(1, R.drawable.ic_avatar, "Martin Palmer", "Today, 03:24 PM",
            "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin….",
            R.drawable.ic_content, "$340.00")
        )
        homes.add(
            Home(2, R.drawable.ic_avatar, "Martin Palmer", "Today, 03:24 PM",
            "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin….",
            null, "$350.00")
        )
        homes.add(
            Home(3, R.drawable.ic_avatar, "Martin Palmer", "Today, 03:24 PM",
            "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin….",
            R.drawable.ic_content, "$360.00")
        )

        return homes
    }

}