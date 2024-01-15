package com.example.flowsapp.ui.loginfragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flows.utils.NetworkResult
import com.example.flowsapp.domain.usecases.login.LoginUseCase
import com.example.flowsapp.domain.usecases.login.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    @ApplicationContext val appContext: Context,
    private val registerUseCase: RegisterUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<LoginContract.State> by lazy {
        MutableStateFlow(LoginContract.State())
    }
    val uiState: StateFlow<LoginContract.State> = _uiState


    private val _uiError = Channel<String>()
    val uiError = _uiError.receiveAsFlow()

    fun handleEvent(event: LoginContract.Event) {
        when (event) {
            LoginContract.Event.hacerlogin -> {
                hacerLogin()
            }

            LoginContract.Event.passwordOlvidada -> {

            }

            LoginContract.Event.register -> {
                register()
            }
        }


    }

    private fun hacerLogin() {
        viewModelScope.launch {

            loginUseCase.invoke(_uiState.value.email.toString(), _uiState.value.password.toString())
                .collect { result ->
                    when (result) {
                        is NetworkResult.Error -> {
                            _uiState.update {
                                it.copy(
                                    error = result.message,
                                    idLoading = false
                                )
                            }
                        }

                        is NetworkResult.Loading -> _uiState.update { it.copy(idLoading = true) }
                        is NetworkResult.Success -> _uiState.update { it.copy(loginsucces = true) }
                    }


                }
        }
    }


    fun cargarPasswordYemail(email: String, password: String) {

        _uiState.update { it.copy(email = email, password = password) }
    }


    private fun register() {
        viewModelScope.launch {
            registerUseCase
                .invoke(_uiState.value.email.toString(), _uiState.value.password.toString())
                .collect { result ->
                    when (result) {
                        is NetworkResult.Error -> {
                            _uiState.update {
                                it.copy(
                                    error = result.message,
                                    idLoading = false
                                )
                            }
                        }

                        is NetworkResult.Loading -> _uiState.update { it.copy(idLoading = true) }
                        is NetworkResult.Success -> _uiState.update { it.copy(loginsucces = true) }
                    }


                }

        }
    }

}