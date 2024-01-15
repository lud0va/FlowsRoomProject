package com.example.flowsapp.ui.jugadoresfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flowsapp.databinding.JugadoresfragmentBinding
import com.example.flowsapp.domain.modelo.Jugador
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class JugadoresFragment: Fragment() {
    private lateinit var binding: JugadoresfragmentBinding


    private lateinit var jugadoresAdapter: JugadoresAdapter

    private val viewModel: JugadoresViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = JugadoresfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        jugadoresAdapter=JugadoresAdapter(requireContext(),
            object :JugadoresAdapter.JugadoresActions{
                override fun onDelete(jugadores: Jugador) {
                   viewModel.handleEvent(JugadoresContract.Event.borrarJugador)
                }
            })

        with(binding) {
            rvJugadores.adapter = jugadoresAdapter
            rvJugadores.layoutManager = GridLayoutManager(this@JugadoresFragment.context, 1)
        }
        init()
    }
    private fun init(){


        lifecycleScope.launch {
            viewModel.handleEvent(JugadoresContract.Event.PedirDatos)
            viewModel.uiState.collect { state ->
                jugadoresAdapter.submitList(state.jugadores)
            }
        }
    }
}