package com.example.flowsapp.domain.usecases.autor

import com.example.flowsapp.data.local.AutorDao
import com.example.flowsapp.data.modelo.toEntity
import com.example.flowsapp.domain.modelo.Autor

class GetAutorUseCase(val autorDao: AutorDao) {
    suspend fun invoke(id:Int)=autorDao.getAutor(id)
}