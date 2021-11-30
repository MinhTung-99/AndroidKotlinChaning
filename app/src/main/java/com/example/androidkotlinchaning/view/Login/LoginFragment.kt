package com.example.androidkotlinchaning.view.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.androidkotlinchaning.AuthenticationActivity
import com.example.androidkotlinchaning.BaseFragment
import com.example.androidkotlinchaning.databinding.FragmentLoginBinding
import com.example.androidkotlinchaning.view.signup.SignUpFragment

class LoginFragment : BaseFragment() {

    lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtSignUp.setOnClickListener {
            (activity as? AuthenticationActivity)?.navigator?.push(SignUpFragment())
        }

        /*(activity as? AuthenticationActivity)?.viewModel?.getUserRegis()?.observe(viewLifecycleOwner,  Observer {
            Toast.makeText(context, it.emailAddress + "===", Toast.LENGTH_SHORT).show()
        })*/
    }
}