package com.example.flowsapp.data.remote.response

import com.example.flows.data.remote.BaseApiResponse
import com.example.flows.utils.NetworkResult
import com.example.flowsapp.network.services.JuegoService
import com.example.flowsapp.network.services.LoginService
import javax.inject.Inject

class LoginRemoteDataSource @Inject constructor(private val loginService: LoginService) :
    BaseApiResponse() {
    suspend fun getLogin(mail: String, password: String): NetworkResult<Void> {
        return safeApiCall(apiCall = { loginService.getLogin(mail, password) })
    }

    suspend fun doRegister(mail: String, password: String):NetworkResult<Boolean>{
        return safeApiCall(apiCall = {loginService.doRegister(mail, password)})
    }



}