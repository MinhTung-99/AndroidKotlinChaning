package com.example.androidkotlinchaning.model.impl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidkotlinchaning.model.SharePreferentManager
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.UserManager
import com.google.gson.GsonBuilder

class UserManagerImpl(val sharePreferentManager: SharePreferentManager?) : UserManager {

    override fun addUser(user: User): LiveData<Boolean> {
        val gson = GsonBuilder().create()
        var users = ArrayList<User>()
        if (sharePreferentManager?.read("users") != null) {
            users.addAll(
                gson.fromJson(
                    sharePreferentManager?.read("users"),
                    Array<User>::class.java
                ).toList()
            )
        }
        users.add(user)
        val json = gson.toJson(users)
        sharePreferentManager?.save("users", json)

        val isAdded = MutableLiveData<Boolean>()
        isAdded.value = true

        return isAdded
    }

    override fun deleteUser(user: User): LiveData<Unit> {
        TODO("Not yet implemented")
    }

    override fun updateUser(user: User): LiveData<User> {
        TODO("Not yet implemented")
    }

    override fun getUser(id: Long): LiveData<User> {
        TODO("Not yet implemented")
    }

    override fun getUsers(): LiveData<List<User>> {
        val gson = GsonBuilder().create()
        var users: List<User> = ArrayList()
        if (sharePreferentManager?.read("users") != null) {
            users = gson.fromJson(sharePreferentManager?.read("users"), Array<User>::class.java).toList()
        }

        val usersLiveData = MutableLiveData<List<User>>()
        usersLiveData.value = users
        return usersLiveData
    }
}