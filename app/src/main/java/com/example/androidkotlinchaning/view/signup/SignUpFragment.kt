package com.example.androidkotlinchaning.view.signup

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.BaseFragment
import com.example.androidkotlinchaning.databinding.FragmentSignUpBinding
import com.example.androidkotlinchaning.model.Navigator
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.impl.NavigatorImpl
import com.example.androidkotlinchaning.utlis.InjectUtils
import com.google.gson.GsonBuilder

class SignUpFragment : BaseFragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var navigator: Navigator

    lateinit var viewModelFactory: SignUpViewModelFactory
    private lateinit var viewModel: SignUpViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        InjectUtils.inject(this)
        viewModel = viewModelFactory.create(SignUpViewModel::class.java)
        navigator = NavigatorImpl(requireActivity() as BaseActivity)

        binding.btnSignUp.setOnClickListener {
            val user = viewModel.getUser().value?.let { it1 ->
                User (
                    it1.size,
                    binding.edtName.text.toString(),
                    binding.edtEmail.text.toString(),
                    binding.edtPassword.text.toString()
                )
            }

            val isAdded = user?.let { it1 -> viewModel.addUser(it1) }

            if (isAdded?.value == true) {
                Toast.makeText(context, viewModel.getUser().value?.size.toString() + "==", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(context,  "email not true", Toast.LENGTH_SHORT).show()
            }

            //viewModel.register(user)
            //navigator.pop()
        }
    }
}