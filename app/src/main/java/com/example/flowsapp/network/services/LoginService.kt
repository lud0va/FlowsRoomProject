package com.example.flowsapp.network.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LoginService {
    @GET("/user/login")
    suspend fun getLogin(@Query("mail")mail:String,@Query("password")password:String): Response<Void>

    @POST("/user/register")
    suspend fun doRegister(@Query("email") email: String, @Query("password") password: String): Response<Boolean>












}