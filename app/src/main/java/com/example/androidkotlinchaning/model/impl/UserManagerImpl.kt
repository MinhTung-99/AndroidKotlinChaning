package com.example.androidkotlinchaning.model.impl

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidkotlinchaning.model.SharePreferentManager
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.UserManager
import com.google.gson.GsonBuilder
import org.json.JSONArray

class UserManagerImpl(val sharePreferentManager: SharePreferentManager?) : UserManager {

    lateinit var isAdded: MutableLiveData<Boolean>
    var users = ArrayList<User>()

    override fun addUser(user: User): LiveData<Boolean> {
        users.add(user)
        val gson = GsonBuilder().create()
        val json = gson.toJson(users)
        sharePreferentManager?.save("users", json)

        isAdded = MutableLiveData()
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
        TODO("Not yet implemented")
    }
}