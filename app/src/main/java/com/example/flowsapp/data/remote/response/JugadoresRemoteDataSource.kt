package com.example.flowsapp.data.remote.response

import com.example.flows.data.remote.BaseApiResponse
import com.example.flows.utils.NetworkResult
import com.example.flowsapp.data.modelo.JuegoDesc
import com.example.flowsapp.data.modelo.JugadorDesc
import com.example.flowsapp.domain.modelo.Jugador
import com.example.flowsapp.network.services.JuegoService
import com.example.flowsapp.network.services.JugadorService
import javax.inject.Inject

class JugadoresRemoteDataSource @Inject constructor(private val jugadorService: JugadorService) :
    BaseApiResponse() {

    suspend fun getAll(): NetworkResult<List<JugadorDesc>> {
        return safeApiCall(apiCall = { jugadorService.getAllJugador() })
    }

    suspend fun getJugador(id: Int): NetworkResult<JugadorDesc> {
        return safeApiCall(apiCall = { jugadorService.getJugador(id) })

    }

    suspend fun deleteJugador(id: Int):NetworkResult<Void> {
        return safeApiCall(apiCall = {jugadorService.deleteJugador(id)})
    }

    suspend fun addJugador(jugador: Jugador):NetworkResult<Void>{
        return safeApiCall(apiCall = {jugadorService.addJugador(jugador)})
    }
    suspend fun updateJugador(jugador: Jugador):NetworkResult<Void>{
        return safeApiCall(apiCall = {jugadorService.updateJugador(jugador)})
    }


}