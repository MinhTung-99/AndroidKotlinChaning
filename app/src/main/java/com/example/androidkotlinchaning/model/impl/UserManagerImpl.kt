package com.example.androidkotlinchaning.model.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.androidkotlinchaning.model.SharePreferentManager
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.UserManager
import com.example.androidkotlinchaning.utlis.just
import com.google.gson.GsonBuilder

class UserManagerImpl(private val sharePreferentManager: SharePreferentManager?) : UserManager {
    private val gson = GsonBuilder().create()

    override fun addUser(user: User, policy: UserManager.InsertPolicy): LiveData<Boolean> {
        val users = ArrayList<User>()
        getUsers().value?.let {
            users.addAll(it)
        }
        val userExist = isExist(user.emailAddress)

        when (policy) {
            UserManager.InsertPolicy.UPDATE -> {
                if (userExist) {
                    //update
                    return Transformations.map(updateUser(user)) { return@map it == null }
                } else {
                    //insert
                    insertUser(user, users)
                    return just(true)
                }
            }
            UserManager.InsertPolicy.IGNORE -> {
                return if (userExist) {
                    just(false)
                } else {
                    insertUser(user, users)
                    just(true)
                }
            }
        }
    }

    private fun insertUser(user: User, users: ArrayList<User>) {
        users.add(user)
        val json = gson.toJson(users)
        sharePreferentManager?.save("users", json)
    }

    private fun isExist(email: String): Boolean {
        val users = getUsers().value ?: return false
        return users.filter { it.emailAddress == email }.isNotEmpty()
    }

    override fun deleteUser(user: User): LiveData<Unit> {
        TODO("Not yet implemented")
    }

    override fun updateUser(user: User): LiveData<User?> {
        val users = getUsers().value ?: return just(null)
        val usersUpdate = users.toMutableList()
        var userUpdate: User? = null

        users.forEachIndexed { index, u ->
            if (u.id == user.id) {
                usersUpdate[index] = u
                userUpdate = u
                val json = gson.toJson(users)
                sharePreferentManager?.save("users", json)
            }
        }

        return just(userUpdate)
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