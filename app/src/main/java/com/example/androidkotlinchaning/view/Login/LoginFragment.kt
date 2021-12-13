package com.example.androidkotlinchaning.view.Login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidkotlinchaning.AuthenticationActivity
import com.example.androidkotlinchaning.BaseFragment
import com.example.androidkotlinchaning.MainActivity
import com.example.androidkotlinchaning.databinding.FragmentLoginBinding
import com.example.androidkotlinchaning.utlis.InjectUtils
import com.example.androidkotlinchaning.utlis.handleDelay
import com.example.androidkotlinchaning.utlis.showToast
import com.example.androidkotlinchaning.view.signup.SignUpFragment
import com.example.androidkotlinchaning.view.signup.SignUpViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginFragment : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    lateinit var viewModelFactory: LoginViewModelFactory

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

        InjectUtils.inject(this)
        viewModel = viewModelFactory.create(LoginViewModel::class.java)

        binding.txtSignUp.setOnClickListener {
            (activity as? AuthenticationActivity)?.navigator?.push(SignUpFragment { email, password ->
                //Toast.makeText(context, "$email == $password", Toast.LENGTH_SHORT).show()

                handleDelay(100) {
                    binding.edtEmail.setText(email)
                    binding.edtPassword.setText(password)
                }
            })
        }

        binding.btnSignUp.setOnClickListener {
            showProgressDialog(true)

            handleDelay(300) {
                viewModel.getUser().value?.let {
                    val count = it.filter { user ->
                        user.emailAddress == binding.edtEmail.text.toString() && user.password == binding.edtPassword.text.toString()
                    }.size

                    if (count > 0) {
                        showProgressDialog(false)
                        val intent = Intent(activity, MainActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    } else {
                        showProgressDialog(false)
                        context?.let { context -> showToast(context,"account or password not true") }
                    }
                }
            }
        }
    }
}