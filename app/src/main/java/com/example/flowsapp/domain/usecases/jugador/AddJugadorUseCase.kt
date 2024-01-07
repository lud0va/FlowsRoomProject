package com.example.flowsapp.domain.usecases.jugador

import com.example.flowsapp.data.JugadoresRepository
import com.example.flowsapp.data.modelo.toJugadorEnt
import com.example.flowsapp.domain.modelo.Jugador

class AddJugadorUseCase(val jugadoresRepository: JugadoresRepository) {
    suspend fun invoke(jugador: Jugador)=jugadoresRepository.addJuegador(jugador.toJugadorEnt())
}