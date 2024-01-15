package com.example.flowsapp.ui.jugadoresfragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flows.framework.utils.Utils
import com.example.flows.utils.NetworkResult
import com.example.flowsapp.data.modelo.toJugador
import com.example.flowsapp.data.modelo.toJugadorEntity
import com.example.flowsapp.domain.usecases.jugador.AddJugadorUseCase
import com.example.flowsapp.domain.usecases.jugador.DeleteJugadorUseCase
import com.example.flowsapp.domain.usecases.jugador.GetAllJugadorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JugadoresViewModel @Inject constructor(
    @ApplicationContext val appContext: Context,
    private val getAllJugadorUseCase: GetAllJugadorUseCase,
    private val deleteJugadorUseCase: DeleteJugadorUseCase,
    private val addJugadorUseCase: AddJugadorUseCase

) : ViewModel() {
    private val _uiState: MutableStateFlow<JugadoresContract.State> by lazy {
        MutableStateFlow(JugadoresContract.State())
    }
    val uiState: StateFlow<JugadoresContract.State> = _uiState
    private val _uiError = Channel<String>()
    val uiError = _uiError.receiveAsFlow()

    fun handleEvent(event: JugadoresContract.Event) {
        when(event){
            JugadoresContract.Event.PedirDatos->{
                pedirDatos()
            }
            JugadoresContract.Event.añadirJugador->{

            }
            JugadoresContract.Event.borrarJugador->{

            }
        }

    }
    fun addJugador(){

    }
    fun deletePlayer(){

    }
    fun pedirDatos(){
        viewModelScope.launch {
            if (Utils.hasInternetConnection(context = appContext)) {
                getAllJugadorUseCase.invoke().collect { result ->
                    when (result) {
                        is NetworkResult.Error -> {
                            _uiState.update {
                                it.copy(
                                    error = result.message,
                                    isLoading = false
                                )
                            }
                            //_uiError.send(result.message ?: "Error")
                        }

                        is NetworkResult.Loading -> _uiState.update { it.copy(isLoading = true) }
                        is NetworkResult.Success -> _uiState.update {
                            it.copy(
                                jugadores = result.data?.map { res -> res.toJugador() }
                                    ?: emptyList(), isLoading = false
                            )
                        }
                    }
                }
            }


        }
    }
}