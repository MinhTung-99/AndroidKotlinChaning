package com.example.androidkotlinchaning.model.impl

import android.content.SharedPreferences
import com.example.androidkotlinchaning.model.SharePreferentManager
import com.example.androidkotlinchaning.model.User
import com.google.gson.GsonBuilder

class SharePreferentManagerImpl(private val sharedPref: SharedPreferences?) : SharePreferentManager {
    val editor: SharedPreferences.Editor? by lazy { sharedPref?.edit() }

    override fun save(key: String, value: String) {
        editor?.putString(key, value)
        editor?.commit()
    }

    override fun delete(key: String) {
        editor?.remove(key)
    }

    override fun read(key: String): String? {
        return sharedPref?.getString(key, null)
    }

    override fun <T> readArray(key: String, list: Array<T>): List<T> {
        val gson = GsonBuilder().create()
        if (read("users") != null) {
            return gson.fromJson(
                read(key),
                list::class.java
            ).toList()
        }

        return emptyList()
    }
}