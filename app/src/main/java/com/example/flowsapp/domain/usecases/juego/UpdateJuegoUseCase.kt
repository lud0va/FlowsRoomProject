package com.example.flowsapp.domain.usecases.juego

import com.example.flowsapp.data.JuegoRepository
import com.example.flowsapp.data.modelo.toJuegoEnt
import com.example.flowsapp.domain.modelo.Juego
import javax.inject.Inject

class UpdateJuegoUseCase  @Inject constructor(val juegoRepository: JuegoRepository)  {
    suspend fun invoke(juego: Juego)=juegoRepository.updateJuego(juego.toJuegoEnt())
}