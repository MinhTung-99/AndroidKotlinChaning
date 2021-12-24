package com.example.androidkotlinchaning.repository.impl

import com.example.androidkotlinchaning.datasource.HomeDataSource
import com.example.androidkotlinchaning.model.Home
import com.example.androidkotlinchaning.repository.HomeRepository

class HomeRepositoryImpl (
    private val homeDataSource: HomeDataSource
) : HomeRepository {
    override fun getHome(): MutableList<Home> {
        return homeDataSource.getHome()
    }

}