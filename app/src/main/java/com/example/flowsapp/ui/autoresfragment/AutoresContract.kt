package com.example.flowsapp.ui.autoresfragment

import com.example.flowsapp.domain.modelo.Autor

interface AutoresContract {
    sealed class Event(){
        object  PedirDatos :Event()
        object borrarAutores: Event()
        object añadirAutores:Event()


    }
    data class State(
        val autores: List<Autor> = emptyList(),
        val autor: Autor?=null,
        val isLoading:Boolean=false,
        val error:String?=null
    )
}