package com.example.flowsapp.domain.usecases.jugador

import com.example.flowsapp.data.JugadoresRepository

class DeleteJugadorUseCase(val jugadoresRepository: JugadoresRepository) {
    suspend fun invoke(id:Int)=jugadoresRepository.deleteJugador(id)
}