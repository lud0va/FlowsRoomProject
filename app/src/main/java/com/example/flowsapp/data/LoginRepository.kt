package com.example.flowsapp.data

import com.example.flows.utils.NetworkResult
import com.example.flowsapp.data.local.JugadorDao
import com.example.flowsapp.data.modelo.JugadorDesc
import com.example.flowsapp.data.remote.response.JugadoresRemoteDataSource
import com.example.flowsapp.data.remote.response.LoginRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginRepository@Inject constructor(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

)  {

    fun doLogin(mail:String,password:String): Flow<NetworkResult<Void>> {
        return flow {
            emit(NetworkResult.Loading())
            emit(loginRemoteDataSource.getLogin(mail,password))

        }.flowOn(Dispatchers.IO)
    }
    fun doRegister(mail:String,password:String): Flow<NetworkResult<Boolean>> {
        return flow {
            emit(NetworkResult.Loading())
            emit(loginRemoteDataSource.doRegister(mail,password))

        }.flowOn(Dispatchers.IO)
    }


}