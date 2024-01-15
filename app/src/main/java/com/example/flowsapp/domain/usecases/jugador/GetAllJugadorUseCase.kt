package com.example.flowsapp.domain.usecases.jugador

import com.example.flowsapp.data.JugadoresRepository
import javax.inject.Inject

class GetAllJugadorUseCase @Inject constructor(val jugadoresRepository: JugadoresRepository) {
    suspend fun invoke()=jugadoresRepository.getAll()
}