package com.example.flowsapp.ui.loginfragment

interface LoginContract {
    sealed class Event {

        object hacerlogin : Event()
        object passwordOlvidada:Event()
        object  register:Event()

    }

    data class State(
        val email:String?=null,
        val password:String?=null,
        val idLoading:Boolean=false,
        val  error:String?=null,
        val loginsucces:Boolean=false
        )
}