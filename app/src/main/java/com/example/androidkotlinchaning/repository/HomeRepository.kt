package com.example.androidkotlinchaning.repository

import com.example.androidkotlinchaning.model.Home

interface HomeRepository {
    fun getHome(): MutableList<Home>
}