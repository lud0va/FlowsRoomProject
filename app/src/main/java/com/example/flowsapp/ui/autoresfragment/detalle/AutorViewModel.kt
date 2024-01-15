package com.example.flowsapp.ui.autoresfragment.detalle

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowsapp.data.modelo.toAutor
import com.example.flowsapp.data.modelo.toLibro
import com.example.flowsapp.domain.modelo.Libro
import com.example.flowsapp.domain.usecases.autor.GetAutorUseCase
import com.example.flowsapp.domain.usecases.libro.AddLibroUseCase
import com.example.flowsapp.domain.usecases.libro.DeleteLibroUseCase
import com.example.flowsapp.domain.usecases.libro.GetAllLibroUseCase
import com.example.flowsapp.domain.usecases.libro.GetLibroUseCase
import com.example.flowsapp.ui.autoresfragment.AutoresContract
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AutorViewModel@Inject constructor(
    @ApplicationContext val appContext: Context,
    val getAutorUseCase: GetAutorUseCase,
    val getAllLibroUseCase: GetAllLibroUseCase,
    val deleteLibroUseCase: DeleteLibroUseCase,
    val addLibroUseCase: AddLibroUseCase,
    val getLibroUseCase: GetLibroUseCase
) : ViewModel() {
    private var listAutor = mutableListOf<Libro>()
    private val _uiState: MutableStateFlow<AutorContract.State> by lazy {
        MutableStateFlow(AutorContract.State())
    }

    val uiState: StateFlow<AutorContract.State> = _uiState
    private val _uiError = Channel<String>()
    val uiError = _uiError.receiveAsFlow()
    fun handleEvent(event: AutorContract.Event) {
        when (event) {
            AutorContract.Event.PedirDatos -> {
                pedirDatos()
            }

            AutorContract.Event.añadirLibro -> {
                addAutor()
            }

            AutorContract.Event.borrarLibro -> {
                deleteAutor()
            }


            else -> {}
        }

    }



    fun addAutor() {
        viewModelScope.launch {
            val libro=Libro(getAllLibroUseCase.invoke().size+1,_uiState.value.autor.id,"s")
            listAutor.add(libro)
            _uiState.value = _uiState.value.copy(libros = listAutor)
            addLibroUseCase.invoke(libro)


        }
    }

    fun getAutor(id:Int){
        viewModelScope.launch {

            var autor=getAutorUseCase.invoke(id)
            _uiState.update {
                it.copy(autor=autor.toAutor())
            }
            }

    }
    fun deleteAutor() {

    }

    fun pedirDatos() {
        viewModelScope.launch {


            val libros = getLibroUseCase.invoke(_uiState.value.autor.id).map { jug -> jug.toLibro() }


            _uiState.value = _uiState.value.copy(libros = libros)

        }
    }









}