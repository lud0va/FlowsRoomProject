package com.example.flowsapp.data.modelo

import com.example.flowsapp.domain.modelo.Jugador
import java.time.LocalDate

data class JugadorDesc(
    val  id:Int,
    val nombre:String,


)fun JugadorDesc.toJugador(): Jugador = Jugador(id,nombre)