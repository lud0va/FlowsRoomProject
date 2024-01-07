package com.example.flowsapp.domain.usecases.juego

import com.example.flowsapp.data.JuegoRepository
import com.example.flowsapp.data.JugadoresRepository
import com.example.flowsapp.data.modelo.toJuegoEnt
import com.example.flowsapp.domain.modelo.Juego

class AddJuegoUseCase(val juegoRepository: JuegoRepository)  {

    suspend fun invoke(juego: Juego)=juegoRepository.addJuego(juego.toJuegoEnt())

}