package com.example.flowsapp.domain.usecases.libro

import com.example.flowsapp.data.local.LibroDao
import com.example.flowsapp.data.modelo.toEntity
import com.example.flowsapp.domain.modelo.Libro
import javax.inject.Inject

class AddLibroUseCase @Inject constructor(val libroDao: LibroDao) {
    suspend fun invoke(libro: Libro)=libroDao.insert(libro.toEntity())
}