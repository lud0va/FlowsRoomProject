package com.example.flowsapp.domain.usecases.autor

import com.example.flowsapp.data.local.AutorDao
import javax.inject.Inject

class GetAllAutorUseCase @Inject constructor(val autorDao: AutorDao) {
   suspend  fun invoke()=autorDao.getAll()
}