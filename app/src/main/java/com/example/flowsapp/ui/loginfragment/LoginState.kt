package com.example.flowsapp.ui.loginfragment

data class LoginState(
    val emal:String?,
    val password:String?,
    val idLoading:Boolean=false,
    val  error:String?=null,

)