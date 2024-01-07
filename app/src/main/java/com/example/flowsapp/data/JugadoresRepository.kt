package com.example.flowsapp.data

import com.example.flows.utils.NetworkResult
import com.example.flowsapp.data.local.JugadorDao
import com.example.flowsapp.data.modelo.JuegoDesc
import com.example.flowsapp.data.modelo.JuegoEntity
import com.example.flowsapp.data.modelo.JugadorDesc
import com.example.flowsapp.data.modelo.JugadorEntity
import com.example.flowsapp.data.modelo.toJuego
import com.example.flowsapp.data.modelo.toJugador
import com.example.flowsapp.data.modelo.toJugadorEntity
import com.example.flowsapp.data.remote.response.JugadoresRemoteDataSource
import com.example.flowsapp.domain.modelo.Juego
import com.example.flowsapp.domain.modelo.Jugador
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class JugadoresRepository @Inject constructor(
    private val jugadoresRemoteDataSource: JugadoresRemoteDataSource,
    private val jugadorDao: JugadorDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

) {

    fun getAll(): Flow<NetworkResult<List<JugadorDesc>>> {
        return flow {

            emit(NetworkResult.Loading())
            val result = jugadoresRemoteDataSource.getAll()
            emit(result)
            //Cache to database if response is successful
            if (result is NetworkResult.Success) {
                result.data?.let { it ->
                    jugadorDao.deleteAll(it.map { it.toJugadorEntity() })
                    jugadorDao.insertAll(it.map { it.toJugadorEntity() })
                }
            }

        }.flowOn(dispatcher)
    }

    fun getJugador(id:Int):Flow<NetworkResult<JugadorDesc>>{
        return flow {
            emit(NetworkResult.Loading())
            emit(jugadoresRemoteDataSource.getJugador(id))

        }.flowOn(Dispatchers.IO)
    }

    fun deleteJugador(id: Int):Flow<NetworkResult<Void>>{
        return flow {
            emit(NetworkResult.Loading())
            val result=jugadoresRemoteDataSource.deleteJugador(id)
            emit(result)
            if (result is NetworkResult.Success){
                result.data?.let {it->
                    jugadorDao.delete(id)

                }
            }
        }.flowOn(Dispatchers.IO)
    }
    fun addJuegador(jugadorEntity: JugadorEntity):Flow<NetworkResult<Void>>{

        return flow {
            emit(NetworkResult.Loading())
            val result=jugadoresRemoteDataSource.addJugador(jugadorEntity.toJugador())
            emit(result)
            if (result is NetworkResult.Success){

                result.data?.let {

                        it->jugadorDao.insertAll(listOf( jugadorEntity))
                }
            }

        }.flowOn(Dispatchers.IO)
    }

    fun updateJugador(jugadorEntity: JugadorEntity):Flow<NetworkResult<Void>>{
        return flow {
            emit(NetworkResult.Loading())
            val result=jugadoresRemoteDataSource.updateJugador(jugadorEntity.toJugador())
            emit(result)
            if (result is NetworkResult.Success){
                result.data?.let {
                    it->jugadorDao.update(jugadorEntity)
                }
            }

        }.flowOn(Dispatchers.IO)
    }
}