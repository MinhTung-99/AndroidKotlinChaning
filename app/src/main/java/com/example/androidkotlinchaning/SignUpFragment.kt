package com.example.androidkotlinchaning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidkotlinchaning.databinding.FragmentSignUpBinding
import com.example.androidkotlinchaning.model.Navigator
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.impl.NavigatorImpl
import com.example.androidkotlinchaning.viewmodel.SignUpViewModel

class SignUpFragment : BaseFragment() {

    lateinit var binding: FragmentSignUpBinding
    lateinit var viewModel: SignUpViewModel
    lateinit var navigator: Navigator

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

        navigator = NavigatorImpl(requireActivity() as BaseActivity)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        val user = User("1", "2", "3")
        viewModel.register(user)

        binding.btnSignUp.setOnClickListener {
            navigator.pop()
        }
    }
}