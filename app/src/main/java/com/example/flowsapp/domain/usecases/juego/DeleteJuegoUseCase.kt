package com.example.flowsapp.domain.usecases.juego

import com.example.flowsapp.data.JuegoRepository
import com.example.flowsapp.data.modelo.toJuegoEnt
import com.example.flowsapp.domain.modelo.Juego
import javax.inject.Inject

class DeleteJuegoUseCase  @Inject constructor(val juegoRepository: JuegoRepository)  {
    suspend fun invoke(id:Int,juego: Juego)=juegoRepository.deleteJuego(id,juego.toJuegoEnt())
}