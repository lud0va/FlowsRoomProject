package com.example.flowsapp.data.modelo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.flowsapp.domain.modelo.Jugador
import java.time.LocalDate
@Entity(tableName ="jugador")
data class JugadorEntity(
    @NonNull
    @PrimaryKey(autoGenerate = true)

    val  id:Int,
    @ColumnInfo("nombre")
    val nombre:String,


)

fun JugadorEntity.toJugador():Jugador= Jugador(id, nombre)
fun Jugador.toJugadorDesc():JugadorDesc=JugadorDesc(id=this.id,nombre=this.nombre)
fun Jugador.toJugadorEnt():JugadorEntity=JugadorEntity(id=this.id,nombre=this.nombre)

fun JugadorDesc.toJugadorEntity():JugadorEntity=JugadorEntity(id=this.id,nombre=this.nombre)