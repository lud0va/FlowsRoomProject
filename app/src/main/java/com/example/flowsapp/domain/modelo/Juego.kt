package com.example.flowsapp.domain.modelo

import androidx.room.Entity


data class Juego(
    val id: Int,
    val idJugador: Int,
    val juego: String
)