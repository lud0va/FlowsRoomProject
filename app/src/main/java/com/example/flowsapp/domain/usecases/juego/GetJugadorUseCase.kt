package com.example.flowsapp.domain.usecases.juego

import com.example.flowsapp.data.JuegoRepository
import com.example.flowsapp.data.modelo.toJuegoEnt
import com.example.flowsapp.domain.modelo.Juego

class GetJugadorUseCase(val juegoRepository: JuegoRepository)  {
    suspend fun invoke(id:Int)=juegoRepository.getJuego(id)
}