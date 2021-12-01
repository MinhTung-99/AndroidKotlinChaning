package com.example.androidkotlinchaning.view.signup

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
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

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var navigator: Navigator
    private lateinit var viewModel: SignUpViewModel
    private lateinit var userManagerImpl: UserManagerImpl
    private lateinit var sharePreferentManager: SharePreferentManager
    private var sharedPref: SharedPreferences? = null


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
        sharedPref = context?.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        sharePreferentManager = SharePreferentManagerImpl(sharedPref)
        userManagerImpl = UserManagerImpl(sharePreferentManager)
        val gson = GsonBuilder().create()
        binding.btnSignUp.setOnClickListener {
            if (sharePreferentManager.read("users") != null) {
                val model = gson.fromJson(sharePreferentManager.read("users"),Array<User>::class.java).toList()
                val isAdded = addUser(model.size + 1)

                if (isAdded.value == true) {
                    Toast.makeText(context, sharePreferentManager.read("users"), Toast.LENGTH_SHORT).show()
                }
            } else {
                val isAdded = addUser(1)

                if (isAdded.value == true) {
                    val model = gson.fromJson(sharePreferentManager.read("users"),Array<User>::class.java).toList()
                    Toast.makeText(context, sharePreferentManager.read("users"), Toast.LENGTH_SHORT).show()
                }
            }

            //viewModel.register(user)
            //navigator.pop()
        }
    }

    private fun addUser (size: Int) : LiveData<Boolean> {
        val user = User(
            size,
            binding.edtName.text.toString(),
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )
        return userManagerImpl.addUser(user)
    }
}