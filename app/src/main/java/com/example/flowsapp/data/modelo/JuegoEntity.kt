package com.example.flowsapp.data.modelo

import androidx.room.Entity
import com.example.flowsapp.domain.modelo.Juego

@Entity(tableName = "juego")
class JuegoEntity(
    val id: Int,
    val idJugador: Int,
    val juego: String

)

fun JuegoEntity.toJuego():Juego=Juego(id,idJugador,juego)
fun Juego.toJuegoDesc():JuegoDesc=JuegoDesc(id=this.id,idJugador=this.idJugador,juego=this.juego)
fun Juego.toJuegoEnt():JuegoEntity=JuegoEntity(id=this.id,idJugador=this.idJugador,juego=this.juego)
fun JuegoDesc.toJuegoEntity():JuegoEntity=JuegoEntity(id=this.id,idJugador=this.idJugador,juego=this.juego)