package com.example.flowsapp.domain.usecases.jugador

import com.example.flowsapp.data.JugadoresRepository
import javax.inject.Inject

class GetJugadorUseCase @Inject constructor(val jugadoresRepository: JugadoresRepository)  {
    suspend fun invoke(id:Int)= jugadoresRepository.getJugador(id)
}