package com.example.androidkotlinchaning.model

import androidx.lifecycle.LiveData

interface UserManager {
    fun addUser(user: User) : LiveData<Boolean>
    fun deleteUser(user: User) : LiveData<Unit>
    fun updateUser(user: User) : LiveData<User>
    fun getUser(id: Long) : LiveData<User>
    fun getUsers(): LiveData<List<User>>
}