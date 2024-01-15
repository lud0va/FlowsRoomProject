package com.example.flowsapp.domain.usecases.jugador

import com.example.flowsapp.data.JugadoresRepository
import com.example.flowsapp.data.modelo.toJugadorEnt
import com.example.flowsapp.domain.modelo.Jugador
import javax.inject.Inject

class AddJugadorUseCase @Inject constructor(val jugadoresRepository: JugadoresRepository) {
    suspend fun invoke(jugador: Jugador)=jugadoresRepository.addJuegador(jugador.toJugadorEnt())
}