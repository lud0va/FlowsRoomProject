package com.example.flowsapp.data.remote.response

import com.example.flows.data.remote.BaseApiResponse
import com.example.flows.utils.NetworkResult
import com.example.flowsapp.data.modelo.JuegoDesc
import com.example.flowsapp.domain.modelo.Juego
import com.example.flowsapp.network.services.JuegoService
import retrofit2.Response
import javax.inject.Inject

class JuegoRemoteDataSource @Inject constructor(private val juegoService: JuegoService) :
    BaseApiResponse(){

   suspend fun getAll():NetworkResult<List<JuegoDesc>>{
       return safeApiCall(apiCall = {juegoService.getAll()})
   }

    suspend fun addGame(juego: Juego): NetworkResult<Void> {
        return safeApiCall(apiCall = { juegoService.addGame(juego) })
    }

    suspend fun deleteGame(id:Int):NetworkResult<Void>{
        return safeApiCall(apiCall = {juegoService.deleteGame(id)})
    }

    suspend fun getGamesPorJugador(id:Int):NetworkResult<List<JuegoDesc>>{
        return safeApiCall(apiCall = {juegoService.getGamesPorJugador(id)})
    }

    suspend fun getJuego(id:Int):NetworkResult<JuegoDesc>{
        return safeApiCall(apiCall = {juegoService.getJuego(id)})
    }
    suspend fun updateGame(juego: Juego):NetworkResult<Void>{
        return safeApiCall(apiCall = {juegoService.updateGame(juego)})
    }


}