package com.example.flowsapp.domain.usecases.jugador

import com.example.flowsapp.data.JugadoresRepository

class GetAllJugadorUseCase(val jugadoresRepository: JugadoresRepository) {
    suspend fun invoke()=jugadoresRepository.getAll()
}