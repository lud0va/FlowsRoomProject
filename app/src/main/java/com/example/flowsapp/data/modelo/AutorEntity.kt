package com.example.flowsapp.data.modelo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.flowsapp.domain.modelo.Autor
import java.time.LocalDate

@Entity(tableName = "autor")
data class AutorEntity(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val fechaDefunc: LocalDate
)

fun Autor.toEntity():AutorEntity= AutorEntity(id,nombre, fechaDefunc)