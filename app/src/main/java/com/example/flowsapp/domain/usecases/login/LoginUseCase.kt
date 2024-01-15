package com.example.flowsapp.domain.usecases.login

import com.example.flowsapp.data.JugadoresRepository
import com.example.flowsapp.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(val loginRepository: LoginRepository)  {
    suspend fun invoke(mail:String,password:String)=loginRepository.doLogin(mail,password)
}