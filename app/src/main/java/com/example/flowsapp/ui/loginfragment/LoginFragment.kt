package com.example.flowsapp.ui.loginfragment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.flowsapp.databinding.LoginViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: Fragment(){
    private lateinit var binding: LoginViewBinding
    private lateinit var loginAdapter: LoginAdapter

    private val viewModel: LoginViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginViewBinding.inflate(layoutInflater)


        init()

    }
    private fun init() {

    }












}