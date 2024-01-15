package com.example.flowsapp.ui.autoresfragment.detalle

import com.example.flowsapp.domain.modelo.Autor
import com.example.flowsapp.domain.modelo.Libro

interface AutorContract {
    sealed class Event(){
        object  PedirDatos :Event()
        object borrarLibro: Event()
        object añadirLibro:Event()


    }
    data class State(
        val libros: List<Libro> = emptyList(),
        val autor: Autor=Autor(0,"ds"),
        val libro: Libro?=null,
        val isLoading:Boolean=false,
        val error:String?=null
    )
}