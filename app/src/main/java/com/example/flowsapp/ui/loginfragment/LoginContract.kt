package com.example.flowsapp.ui.loginfragment

interface LoginContract {
    sealed class Event {

        object hacerlogin : Event()
        object mostrarMensaje: Event()
        object  passwordolvidada:Event()

    }

    data class State(
        val email:String?=null,
        val password:String?=null,
        val idLoading:Boolean=false,
        val  error:String?=null

        )
}