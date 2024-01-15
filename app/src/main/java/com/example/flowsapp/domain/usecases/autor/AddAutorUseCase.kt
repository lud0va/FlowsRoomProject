package com.example.flowsapp.domain.usecases.autor

import com.example.flowsapp.data.local.AutorDao
import com.example.flowsapp.data.modelo.toEntity
import com.example.flowsapp.domain.modelo.Autor
import javax.inject.Inject

class AddAutorUseCase @Inject constructor(val autorDao: AutorDao) {

    suspend fun invoke(autor:Autor)=autorDao.insert(autor.toEntity())
}