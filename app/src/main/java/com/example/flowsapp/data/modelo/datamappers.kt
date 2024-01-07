package com.example.flowsapp.data.modelo

import com.example.flowsapp.domain.modelo.Libro

fun LibroEntity.toLibro(): Libro {
    return Libro(this.id,this.idAutor,this.libro)
}