package com.example.flowsapp.data

import com.example.flows.utils.NetworkResult
import com.example.flowsapp.data.local.JuegoDao
import com.example.flowsapp.data.local.JugadorDao
import com.example.flowsapp.data.modelo.JuegoDesc
import com.example.flowsapp.data.modelo.JuegoEntity
import com.example.flowsapp.data.modelo.JugadorDesc
import com.example.flowsapp.data.modelo.JugadorEntity
import com.example.flowsapp.data.modelo.toJuego
import com.example.flowsapp.data.modelo.toJuegoEntity
import com.example.flowsapp.data.modelo.toJugador
import com.example.flowsapp.data.modelo.toJugadorEntity
import com.example.flowsapp.data.remote.response.JuegoRemoteDataSource
import com.example.flowsapp.data.remote.response.JugadoresRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class JuegoRepository @Inject constructor(
    private val juegoRemoteDataSource: JuegoRemoteDataSource,
    private val juegoDao: JuegoDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

)  {

    fun getAll(): Flow<NetworkResult<List<JuegoDesc>>> {
        return flow {

            emit(NetworkResult.Loading())
            val result = juegoRemoteDataSource.getAll()
            emit(result)
            //Cache to database if response is successful
            if (result is NetworkResult.Success) {
                result.data?.let { it ->
                    juegoDao.deleteAll(it.map { it.toJuegoEntity() })
                    juegoDao.insertAll(it.map { it.toJuegoEntity() })
                }
            }

        }.flowOn(dispatcher)


    }


    fun getJuego(id:Int):Flow<NetworkResult<JuegoDesc>>{
        return flow {
            emit(NetworkResult.Loading())
            emit(juegoRemoteDataSource.getJuego(id))

        }.flowOn(Dispatchers.IO)
    }

    fun deleteJuego(id: Int):Flow<NetworkResult<Void>>{
        return flow {
            emit(NetworkResult.Loading())
            val result=juegoRemoteDataSource.deleteGame(id)
            emit(result)
            if (result is NetworkResult.Success){
                result.data?.let {it->
                    juegoDao.delete(id)

                }
            }
        }.flowOn(Dispatchers.IO)
    }

    fun addJuego(juegoEntity: JuegoEntity):Flow<NetworkResult<Void>>{

        return flow {
            emit(NetworkResult.Loading())
            val result=juegoRemoteDataSource.addGame(juegoEntity.toJuego())
            emit(result)
            if (result is NetworkResult.Success){

                result.data?.let {

                        it->juegoDao.insertAll(listOf( juegoEntity))
                }
            }

        }.flowOn(Dispatchers.IO)
    }

    fun updateJuego(juegoEntity: JuegoEntity):Flow<NetworkResult<Void>>{
        return flow {
            emit(NetworkResult.Loading())
            val result=juegoRemoteDataSource.updateGame(juegoEntity.toJuego())
            emit(result)
            if (result is NetworkResult.Success){
                result.data?.let {
                        it->juegoDao.update(juegoEntity)
                }
            }

        }.flowOn(Dispatchers.IO)
    }

















}