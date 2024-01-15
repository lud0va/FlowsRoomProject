package com.example.flowsapp.data.modelo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.flowsapp.domain.modelo.Juego

@Entity(
    tableName = "juego",
    foreignKeys = [
        ForeignKey(entity = JugadorEntity::class,
            parentColumns = ["id"],
            childColumns = ["idJugador"])
    ],
    indices = [Index("idJugador")]
)
class JuegoEntity(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("idJugador")
    val idJugador: Int,
    @ColumnInfo("nombre")
    val juego: String

)

fun JuegoEntity.toJuego():Juego=Juego(id,idJugador,juego)
fun Juego.toJuegoDesc():JuegoDesc=JuegoDesc(id=this.id,idJugador=this.idJugador,juego=this.juego)
fun Juego.toJuegoEnt():JuegoEntity=JuegoEntity(id=this.id,idJugador=this.idJugador,juego=this.juego)
fun JuegoDesc.toJuegoEntity():JuegoEntity=JuegoEntity(id=this.id,idJugador=this.idJugador,juego=this.juego)