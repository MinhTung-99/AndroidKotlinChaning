package com.example.androidkotlinchaning.model

interface SharePreferentManager {

    fun save (key: String, value: String)
    fun delete (key: String)
    fun read (key: String) : String?
    fun<T> readArray (key: String, list: Array<T>): List<T>
}