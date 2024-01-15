package com.example.flowsapp.domain.usecases.libro

import com.example.flowsapp.data.local.LibroDao
import com.example.flowsapp.data.modelo.toEntity
import com.example.flowsapp.domain.modelo.Libro
import javax.inject.Inject

class GetAllLibroUseCase  @Inject constructor(val libroDao: LibroDao) {
    suspend fun invoke()=libroDao.getAll()
}