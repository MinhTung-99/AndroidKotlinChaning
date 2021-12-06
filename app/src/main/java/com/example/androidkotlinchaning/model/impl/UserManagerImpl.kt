package com.example.androidkotlinchaning.model.impl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidkotlinchaning.model.SharePreferentManager
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.UserManager
import com.example.androidkotlinchaning.utlis.ValidateUtils
import com.google.gson.GsonBuilder

class UserManagerImpl(val sharePreferentManager: SharePreferentManager?) : UserManager {

    override fun addUser(user: User): LiveData<Boolean> {
        val gson = GsonBuilder().create()
        var users = ArrayList<User>()
        sharePreferentManager?.let {
            users.addAll(
                it.readArray("users", emptyArray())
            )
        }
        val isAdded = MutableLiveData<Boolean>()
        if (ValidateUtils.isValidateEmail(user.emailAddress)) {
            users.add(user)
            val json = gson.toJson(users)
            sharePreferentManager?.save("users", json)
            isAdded.value = true
        } else{
            isAdded.value = false
        }

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
        var users: List<User> = ArrayList()
        if (sharePreferentManager != null) {
            users = sharePreferentManager.readArray("users", emptyArray())
        }

        val usersLiveData = MutableLiveData<List<User>>()
        usersLiveData.value = users
        return usersLiveData
    }
}