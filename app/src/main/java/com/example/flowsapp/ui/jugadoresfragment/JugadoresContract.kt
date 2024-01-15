package com.example.flowsapp.ui.jugadoresfragment

import com.example.flowsapp.domain.modelo.Jugador

interface JugadoresContract {

    sealed class Event(){
        object  PedirDatos :Event()
        object borrarJugador: Event()
        object añadirJugador:Event()

    }
    data class State(
        val jugadores: List<Jugador> = emptyList(),
        val jugador: Jugador?=null,
        val isLoading:Boolean=false,
        val error:String?=null
    )
}