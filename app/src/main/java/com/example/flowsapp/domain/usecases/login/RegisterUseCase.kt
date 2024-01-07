package com.example.flowsapp.domain.usecases.login

import com.example.flowsapp.data.LoginRepository

class RegisterUseCase(val loginRepository: LoginRepository) {
    suspend fun invoke(mail:String,password:String)=loginRepository.doRegister(mail, password)

}