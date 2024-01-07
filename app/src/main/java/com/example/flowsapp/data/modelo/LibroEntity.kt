package com.example.flowsapp.data.modelo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.flowsapp.domain.modelo.Autor
import com.example.flowsapp.domain.modelo.Libro

@Entity(tableName = "libro")
data class LibroEntity (
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val idAutor:Int,
    val libro:String

)
fun Libro.toEntity():LibroEntity=LibroEntity(id,idAutor, libro)