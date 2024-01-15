package com.example.flowsapp.domain.usecases.jugador

import com.example.flowsapp.data.JugadoresRepository
import com.example.flowsapp.data.modelo.toJugadorEnt
import com.example.flowsapp.domain.modelo.Jugador
import javax.inject.Inject

class DeleteJugadorUseCase @Inject constructor(val jugadoresRepository: JugadoresRepository) {
    suspend fun invoke(id:Int,jugador: Jugador)=jugadoresRepository.deleteJugador(id,jugador.toJugadorEnt())
}