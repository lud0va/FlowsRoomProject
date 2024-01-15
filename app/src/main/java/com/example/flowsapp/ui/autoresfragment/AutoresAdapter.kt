package com.example.flowsapp.ui.autoresfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.flowsapp.R
import com.example.flowsapp.databinding.JugadorViewBinding
import com.example.flowsapp.domain.modelo.Autor
import com.example.flowsapp.domain.modelo.Jugador
import com.example.flowsapp.ui.SwipeGesture
import com.example.flowsapp.ui.jugadoresfragment.JugadoresAdapter

class AutoresAdapter(
    val context: Context,
    val actions: AutoresAdapter.AutorActions,
    private val cambiarPantalla: (Int) -> Unit

) : ListAdapter<Autor, AutoresAdapter.ItemViewholder>(DiffCallback()) {
    interface AutorActions {
        fun onDelete(autores: Autor)
        fun itemHasClicked(autor: Autor)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {

        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.autor_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) = with(holder) {
        val item = getItem(position)
        bind(item)
    }


    inner class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = JugadorViewBinding.bind(itemView)
        private fun setupClickListeners(autores: Autor, cambiarPantalla: (Int) -> Unit) {
            itemView.setOnClickListener {
                cambiarPantalla(autores.id)
            }


        }

        fun bind(item: Autor) {
            setupClickListeners(item,cambiarPantalla)
            bindViews(item)

        }

        private fun bindViews(autor: Autor) {
            with(binding) {
                tvnombre.text = autor.nombre
                tvId.text = autor.id.toString()
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Autor>() {
        override fun areItemsTheSame(oldItem: Autor, newItem: Autor): Boolean {
            return oldItem.nombre == newItem.nombre
        }

        override fun areContentsTheSame(oldItem: Autor, newItem: Autor): Boolean {
            return oldItem == newItem
        }
    }

    val swipeGesture = object : SwipeGesture(context) {

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            when (direction) {
                ItemTouchHelper.LEFT -> {

                    actions.onDelete(currentList[viewHolder.adapterPosition])

                }
            }

        }
    }

}