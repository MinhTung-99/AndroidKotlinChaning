package com.example.androidkotlinchaning.view.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.BaseFragment
import com.example.androidkotlinchaning.databinding.FragmentSignUpBinding
import com.example.androidkotlinchaning.model.Navigator
import com.example.androidkotlinchaning.model.impl.NavigatorImpl
import com.example.androidkotlinchaning.model.pop
import com.example.androidkotlinchaning.utlis.InjectUtils
import com.example.androidkotlinchaning.utlis.handleDelay
import com.example.androidkotlinchaning.utlis.showToast

class SignUpFragment(val callback:  ((String, String) -> Unit)? = null) : BaseFragment() {


    private lateinit var navigator: Navigator

    lateinit var viewModelFactory: SignUpViewModelFactory
    private lateinit var viewModel: SignUpViewModel
    private lateinit var binding: FragmentSignUpBinding

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
            showProgress()

            val signUpSuccess = viewModel.addUser(
                binding.edtName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString()
            )
            signUpSuccess.observe(requireActivity(), {
                signUpSuccess.removeObservers(viewLifecycleOwner)
                handleDelay(300) {
                    hideProgress()
                    if (it) {
                        callback?.invoke(binding.edtEmail.text.toString(), binding.edtPassword.text.toString())
                        navigator.pop()
                    } else {
                        context?.showToast("not success")
                    }

                }
            })

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