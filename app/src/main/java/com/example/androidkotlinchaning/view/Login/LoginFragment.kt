package com.example.androidkotlinchaning.view.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidkotlinchaning.AuthenticationActivity
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.BaseFragment
import com.example.androidkotlinchaning.CustomProgressDialogFragment
import com.example.androidkotlinchaning.databinding.FragmentLoginBinding
import com.example.androidkotlinchaning.model.AuthenticationNavigator
import com.example.androidkotlinchaning.model.push
import com.example.androidkotlinchaning.utlis.InjectUtils
import com.example.androidkotlinchaning.utlis.handleDelay
import com.example.androidkotlinchaning.utlis.showToast
import com.example.androidkotlinchaning.view.signup.SignUpFragment

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
                handleDelay(100) {
                    binding.edtEmail.setText(email)
                    binding.edtPassword.setText(password)
                }
            })
        }

        binding.btnSignUp.setOnClickListener {
            CustomProgressDialogFragment.show(activity as BaseActivity)

            handleDelay(300) {
                CustomProgressDialogFragment.hide()
                val loginSuccess = viewModel.login(
                    binding.edtEmail.text.toString(),
                    binding.edtPassword.text.toString()
                )

                loginSuccess.observe(requireActivity(), {
                    if (it) {
                        context?.let { context ->
                            ((activity as? AuthenticationActivity)?.navigator as? AuthenticationNavigator)
                                ?.navigateToMain(context)
                        }
                    } else {
                        context?.showToast("account or password not true")
                    }

                    loginSuccess.removeObservers(viewLifecycleOwner)
                })
            }
        }
    }
}