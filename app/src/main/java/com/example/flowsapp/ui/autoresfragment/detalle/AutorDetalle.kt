package com.example.flowsapp.ui.autoresfragment.detalle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flowsapp.R
import com.example.flowsapp.databinding.AutordetalleBinding
import com.example.flowsapp.databinding.AutorfragmentBinding
import com.example.flowsapp.domain.modelo.Autor
import com.example.flowsapp.domain.modelo.Libro
import com.example.flowsapp.ui.autoresfragment.AutoresAdapter
import com.example.flowsapp.ui.autoresfragment.AutoresContract
import com.example.flowsapp.ui.autoresfragment.AutoresFragmentDirections
import com.example.flowsapp.ui.autoresfragment.AutoresViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AutorDetalle : Fragment() {
    private lateinit var binding: AutordetalleBinding


    private lateinit var autoresAdapter: AutorAdapter

    private val viewModel: AutorViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AutordetalleBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        autoresAdapter = AutorAdapter(requireContext(),
            object : AutorAdapter.AutorActions {


                override fun onDelete(libro: Libro) {
                    viewModel.handleEvent(AutorContract.Event.borrarLibro)
                }


            }
        )

        with(binding) {


            rvOrders.adapter = autoresAdapter
            rvOrders.layoutManager = GridLayoutManager(this@AutorDetalle.context, 1)
        }
        init()
        configAppBar()
    }

    private fun configAppBar() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.add -> {
                    viewModel.handleEvent(AutorContract.Event.añadirLibro)
                    true
                }


                else -> false
            }
        }
    }


    private fun init() {

        lifecycleScope.launch {


            viewModel.uiState.collect { state ->
                val ids = arguments?.getInt("id")
                ids?.let { viewModel.getAutor(it) }
                binding.id.text = viewModel.uiState.value.autor.id.toString()
                binding.name.text = viewModel.uiState.value.autor.nombre
                viewModel.handleEvent(AutorContract.Event.PedirDatos)
                autoresAdapter.submitList(state.libros)
            }
        }
    }

}