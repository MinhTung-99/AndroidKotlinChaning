package com.example.androidkotlinchaning.view.signup

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.*
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.BaseFragment
import com.example.androidkotlinchaning.databinding.FragmentSignUpBinding
import com.example.androidkotlinchaning.model.Navigator
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.impl.NavigatorImpl
import com.example.androidkotlinchaning.utlis.InjectUtils
import com.example.androidkotlinchaning.utlis.just
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
            //ADD
            val user = viewModel.getUser().value?.let { it1 ->
                User(
                    it1.size,
                    binding.edtName.text.toString(),
                    binding.edtEmail.text.toString(),
                    binding.edtPassword.text.toString()
                )
            }

            user?.let { it1 ->
                val signUpSuccess = viewModel.addUser(it1)
                signUpSuccess.observe(requireActivity(), {
                    signUpSuccess.removeObservers(viewLifecycleOwner)
                    if (it == true) {
                        navigator.pop()
                    } else {
                        Toast.makeText(context, "not success", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            /*//UPDATE
            val user = User(
                2,
                binding.edtName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString()
            )
            viewModel.addUser(user)
            viewModel.isUser.observe(requireActivity(), {
                Toast.makeText(context, "Success" + it.fullName, Toast.LENGTH_SHORT).show()
            })*/
        }
    }
}