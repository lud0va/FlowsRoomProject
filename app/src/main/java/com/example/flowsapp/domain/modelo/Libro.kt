package com.example.flowsapp.domain.modelo

import androidx.room.Entity


data class Libro(
    val id:Int,
    val idAutor:Int,
    val libro:String
)