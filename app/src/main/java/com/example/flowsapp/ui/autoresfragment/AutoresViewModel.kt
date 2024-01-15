package com.example.flowsapp.ui.autoresfragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flows.framework.utils.Utils
import com.example.flows.utils.NetworkResult
import com.example.flowsapp.data.modelo.toAutor
import com.example.flowsapp.data.modelo.toJugador
import com.example.flowsapp.domain.modelo.Autor
import com.example.flowsapp.domain.usecases.autor.AddAutorUseCase
import com.example.flowsapp.domain.usecases.autor.DeleteAutorUseCase
import com.example.flowsapp.domain.usecases.autor.GetAllAutorUseCase
import com.example.flowsapp.ui.jugadoresfragment.JugadoresContract
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class AutoresViewModel @Inject constructor(
    @ApplicationContext val appContext: Context,
    val getAllAutorUseCase: GetAllAutorUseCase,
    val deleteAutorUseCase: DeleteAutorUseCase,
    val addAutorUseCase: AddAutorUseCase
) : ViewModel() {
    private var listAutor = mutableListOf<Autor>()
    private val _uiState: MutableStateFlow<AutoresContract.State> by lazy {
        MutableStateFlow(AutoresContract.State())
    }
    val uiState: StateFlow<AutoresContract.State> = _uiState
    private val _uiError = Channel<String>()
    val uiError = _uiError.receiveAsFlow()
    fun handleEvent(event: AutoresContract.Event) {
        when (event) {
            AutoresContract.Event.PedirDatos -> {
                pedirDatos()
            }

            AutoresContract.Event.añadirAutores -> {
                addAutor()
            }

            AutoresContract.Event.borrarAutores -> {
                TODO()
            }


            else -> {}
        }

    }


    fun addAutor() {
        viewModelScope.launch {
            val autor = Autor(getAllAutorUseCase.invoke().size + 1, "x")
            listAutor.add(autor)
            _uiState.value = _uiState.value.copy(autores = listAutor)
            addAutorUseCase.invoke(autor)

        }
    }

    fun deleteAutor() {

    }

    fun pedirDatos() {
        viewModelScope.launch {


            val autores = getAllAutorUseCase.invoke().map { jug -> jug.toAutor() }


            _uiState.value = _uiState.value.copy(autores = autores)

        }
    }
}