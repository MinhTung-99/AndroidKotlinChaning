package com.example.androidkotlinchaning.view.signup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.androidkotlinchaning.AuthenticationActivity
import com.example.androidkotlinchaning.BaseActivity
import com.example.androidkotlinchaning.BaseFragment
import com.example.androidkotlinchaning.databinding.FragmentSignUpBinding
import com.example.androidkotlinchaning.model.Navigator
import com.example.androidkotlinchaning.model.SharePreferentManager
import com.example.androidkotlinchaning.model.User
import com.example.androidkotlinchaning.model.impl.NavigatorImpl
import com.example.androidkotlinchaning.model.impl.SharePreferentManagerImpl
import com.example.androidkotlinchaning.model.impl.UserManagerImpl
import com.google.gson.GsonBuilder

class SignUpFragment : BaseFragment() {

    lateinit var binding: FragmentSignUpBinding
    lateinit var navigator: Navigator
    lateinit var viewModel: SignUpViewModel


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
        //viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        binding.btnSignUp.setOnClickListener {
            val user = User(
                binding.edtName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString()
            )

            val sharedPref = context?.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            val sharePreferentManager = SharePreferentManagerImpl(sharedPref)
            val userManagerImpl = UserManagerImpl(sharePreferentManager)
            val isAdded = userManagerImpl.addUser(user)

            if (isAdded.value == true) {
                val gson = GsonBuilder().create()
                val model = gson.fromJson(sharePreferentManager.read("users"),Array<User>::class.java).toList()
                Toast.makeText(context, model[0].emailAddress, Toast.LENGTH_SHORT).show()
            }

            /*val sharedPref = context?.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            val sharePreferentManager = SharePreferentManagerImpl(sharedPref)
            sharePreferentManager.save("name", user.fullName)
            sharePreferentManager.save("email", user.emailAddress)
            sharePreferentManager.save("password", user.password)

            Toast.makeText(context, sharePreferentManager.read("name"), Toast.LENGTH_SHORT).show()*/

            //viewModel.register(user)
            //navigator.pop()
        }
    }
}