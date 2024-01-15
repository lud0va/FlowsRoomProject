package com.example.flowsapp.ui.loginfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.example.flowsapp.databinding.LoginViewBinding
import com.example.flowsapp.ui.ItemsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity :AppCompatActivity() {
    private lateinit var binding: LoginViewBinding
    private lateinit var navController: NavController
    private lateinit var loginAdapter: LoginAdapter

    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        login()
        init()
    }
    private fun init() {
        loginAdapter= LoginAdapter()

    }
    fun cambiarFragment(){

        val intent = Intent(this@MainActivity, ItemsActivity::class.java)
        startActivity(intent)

    }
    fun login(){
        lifecycleScope.launch {
            binding.idlogin.setOnClickListener {

                viewModel.cargarPasswordYemail(binding.emailtext.text.toString(),binding.passwordtext.text.toString())
                viewModel.handleEvent(LoginContract.Event.hacerlogin)

                cambiarFragment()
                if (viewModel.uiState.value.loginsucces){

                }

            }

            binding.passwordoOvidada.setOnClickListener {
                viewModel.handleEvent(LoginContract.Event.register)


            }
            binding.registerBtn.setOnClickListener {
                viewModel.cargarPasswordYemail(binding.emailtext.text.toString(),binding.passwordtext.text.toString())
                viewModel.handleEvent(LoginContract.Event.register)
                if (viewModel.uiState.value.loginsucces)
                    cambiarFragment()
            }

        }
    }





}