package com.example.flowsapp.network.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginService {
    @GET("/user/{mail}&{password}")
    suspend fun getLogin(mail:String,password:String): Response<Void>

    @POST("/user/register/{emai}&{password}")
    suspend fun doRegister(mail: String,password: String): Response<Boolean>













}