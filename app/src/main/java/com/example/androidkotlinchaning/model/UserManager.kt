package com.example.androidkotlinchaning.model

import androidx.lifecycle.LiveData
import com.example.androidkotlinchaning.model.impl.UserManagerImpl

interface UserManager {
    enum class InsertPolicy {
        UPDATE, IGNORE
    }

    fun addUser(user: User, policy: InsertPolicy) : LiveData<Boolean>
    fun deleteUser(user: User) : LiveData<Unit>
    fun updateUser(user: User) : LiveData<User?>
    fun getUser(id: Long) : LiveData<User>
    fun getUsers(): LiveData<List<User>>
}