package com.example.androidkotlinchaning.repository

import com.example.androidkotlinchaning.datasource.HomeDataSource
import com.example.androidkotlinchaning.model.Home

class HomeRepository (
    private val homeDataSource: HomeDataSource
): HomeDataSource{

    override fun getHome(): MutableList<Home> {
        return homeDataSource.getHome()
    }
}