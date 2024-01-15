package com.example.flowsapp.ui.jugadoresfragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.flowsapp.databinding.JugadoresfragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JugadorFragment:Fragment() {
 private lateinit var binding: JugadoresfragmentBinding
 private lateinit var jugadoresAdapter: JugadoresAdapter
 private val viewModel: JugadoresViewModel by viewModels()




}