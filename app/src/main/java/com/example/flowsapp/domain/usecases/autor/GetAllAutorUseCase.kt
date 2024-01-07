package com.example.flowsapp.domain.usecases.autor

import com.example.flowsapp.data.local.AutorDao

class GetAllAutorUseCase(val autorDao: AutorDao) {
    suspend fun invoke()=autorDao.getAll()
}