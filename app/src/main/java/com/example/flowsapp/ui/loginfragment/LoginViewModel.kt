package com.example.flowsapp.ui.loginfragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowsapp.domain.usecases.login.LoginUseCase
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

            LoginContract.Event.mostrarMensaje -> {

            }

            LoginContract.Event.passwordolvidada -> {
                passwordOlvidada()
            }
        }


    }

    private fun hacerLogin() {
        viewModelScope.launch {
            if (_uiState.value.email!=null && _uiState.value.password!=null){
                loginUseCase.loginRepository.doLogin(_uiState.value.email.toString(),_uiState.value.password.toString())

            }
        }
    }

    fun cargarPasswordYemail(email: String, password: String) {

        _uiState.value?.copy(email = email, password = password)


    }

    private fun passwordOlvidada() {

    }

}