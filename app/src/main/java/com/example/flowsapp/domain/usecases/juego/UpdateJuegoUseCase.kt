package com.example.flowsapp.domain.usecases.juego

import com.example.flowsapp.data.JuegoRepository
import com.example.flowsapp.data.modelo.toJuegoEnt
import com.example.flowsapp.domain.modelo.Juego

class UpdateJuegoUseCase(val juegoRepository: JuegoRepository)  {
    suspend fun invoke(juego: Juego)=juegoRepository.updateJuego(juego.toJuegoEnt())
}