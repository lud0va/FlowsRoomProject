package com.example.flowsapp.domain.usecases.login

import com.example.flowsapp.data.LoginRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(val loginRepository: LoginRepository) {
    suspend fun invoke(mail:String,password:String)=loginRepository.doRegister(mail, password)

}