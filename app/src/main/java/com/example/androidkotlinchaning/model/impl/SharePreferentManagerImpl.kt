package com.example.androidkotlinchaning.model.impl

import android.content.SharedPreferences
import com.example.androidkotlinchaning.model.SharePreferentManager

class SharePreferentManagerImpl(val sharedPref: SharedPreferences?) : SharePreferentManager {
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
}