package com.example.androidkotlinchaning.view.notify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidkotlinchaning.BaseFragment
import com.example.androidkotlinchaning.databinding.FragmentNotifyBinding

class NotifyFragment : BaseFragment() {
    private lateinit var binding: FragmentNotifyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotifyBinding.inflate(inflater, container, false)
        return binding.root
    }
}