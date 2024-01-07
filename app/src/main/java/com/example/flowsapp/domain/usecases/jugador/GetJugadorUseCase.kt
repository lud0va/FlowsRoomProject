package com.example.flowsapp.domain.usecases.jugador

import com.example.flowsapp.data.JugadoresRepository

class GetJugadorUseCase(val jugadoresRepository: JugadoresRepository)  {
    suspend fun invoke(id:Int)= jugadoresRepository.getJugador(id)
}