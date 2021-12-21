package com.example.androidkotlinchaning.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidkotlinchaning.BaseViewModel
import com.example.androidkotlinchaning.R
import com.example.androidkotlinchaning.model.Home
import com.example.androidkotlinchaning.repository.HomeRepository
import com.example.androidkotlinchaning.repository.remote.HomeRemoteDataSource

class HomeViewModel : BaseViewModel() {

    private val mutableLiveData: MutableLiveData<MutableList<Home>> by lazy { MutableLiveData() }

    fun getHomes () : LiveData<MutableList<Home>> {
        mutableLiveData.postValue(HomeRepository(HomeRemoteDataSource()).getHome())
        return mutableLiveData
    }
}