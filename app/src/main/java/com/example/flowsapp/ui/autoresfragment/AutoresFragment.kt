package com.example.flowsapp.ui.autoresfragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flowsapp.R
import com.example.flowsapp.databinding.AutorfragmentBinding
import com.example.flowsapp.domain.modelo.Autor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AutoresFragment : Fragment() {
    private lateinit var binding: AutorfragmentBinding


    private lateinit var autoresAdapter: AutoresAdapter

    private val viewModel: AutoresViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AutorfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        autoresAdapter = AutoresAdapter(requireContext(),
            object : AutoresAdapter.AutorActions {
                override fun onDelete(autor: Autor) {
                    viewModel.handleEvent(AutoresContract.Event.borrarAutores)
                }

                override fun itemHasClicked(autor: Autor) {
                   cambiarPantalla(autor.id)

                }
            }, ::cambiarPantalla
        )

        with(binding) {
            rvOrders.adapter = autoresAdapter
            rvOrders.layoutManager = GridLayoutManager(this@AutoresFragment.context, 1)
        }
        init()
        configAppBar()
    }

    private fun configAppBar() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.add -> {
                    viewModel.handleEvent(AutoresContract.Event.añadirAutores)
                    true
                }


                else -> false
            }
        }
    }

    private fun cambiarPantalla(id: Int) {
        findNavController().navigate(AutoresFragmentDirections.autorToDetalle(id))
    }

    private fun init() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->

                viewModel.handleEvent(AutoresContract.Event.PedirDatos)
                autoresAdapter.submitList(state.autores)
            }
        }
    }
}