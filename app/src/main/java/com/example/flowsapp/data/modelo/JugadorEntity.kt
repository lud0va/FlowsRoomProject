package com.example.flowsapp.data.modelo

import androidx.room.Entity
import com.example.flowsapp.domain.modelo.Jugador
import java.time.LocalDate
@Entity(tableName ="jugador")
data class JugadorEntity(
    val  id:Int,
    val nombre:String,
    val fechaNac: LocalDate

)

fun JugadorEntity.toJugador():Jugador= Jugador(id, nombre, fechaNac)
fun Jugador.toJugadorDesc():JugadorDesc=JugadorDesc(id=this.id,nombre=this.nombre, fechaNac = this.fechaNac)
fun Jugador.toJugadorEnt():JugadorEntity=JugadorEntity(id=this.id,nombre=this.nombre, fechaNac = this.fechaNac)

fun JugadorDesc.toJugadorEntity():JugadorEntity=JugadorEntity(id=this.id,nombre=this.nombre, fechaNac = this.fechaNac)