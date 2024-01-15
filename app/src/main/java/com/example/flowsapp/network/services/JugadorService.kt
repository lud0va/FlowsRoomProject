package com.example.flowsapp.network.services

import com.example.flowsapp.data.modelo.JugadorDesc
import com.example.flowsapp.data.modelo.JugadoresResponse
import com.example.flowsapp.domain.modelo.Jugador
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface JugadorService {
    @GET("/jugadores")
    suspend fun getAllJugador(): Response<List<JugadorDesc>>

    @GET("/jugadores/{id}")
    suspend fun getJugador(@Path("id") id:Int):Response<JugadorDesc>

    @DELETE("/jugadores/{id}")
    suspend fun deleteJugador(@Path("id") id: Int): Response<Void>

    @POST("/jugadores")
    suspend fun addJugador(jugador: Jugador): Response<Void>

    @PUT("/jugadores/")
    suspend fun updateJugador(jugador: Jugador): Response<Void>


}