package com.example.flowsapp.network.services

import com.example.flowsapp.data.modelo.JuegoDesc
import com.example.flowsapp.domain.modelo.Juego
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface JuegoService {

    @GET("/juego")
    suspend fun getAll():Response<List<JuegoDesc>>

    @POST("/juego")
    suspend fun addGame(juego:Juego):Response<Void>
    @DELETE("/juego/{id}")
    suspend fun deleteGame(id:Int):Response<Void>
    @GET("juego/porjugador/{idjugador}")
    suspend fun getGamesPorJugador(id:Int):Response<List<JuegoDesc>>
    @GET("/juego/porjuego/{id}")
    suspend fun getJuego(id: Int):Response<JuegoDesc>

    @PUT("/juego")
    suspend fun updateGame(juego: Juego):Response<Void>






}