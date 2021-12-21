package com.example.androidkotlinchaning.datasource

import com.example.androidkotlinchaning.model.Home

interface HomeDataSource {
    fun getHome(): MutableList<Home>
}