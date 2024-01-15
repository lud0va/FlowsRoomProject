package com.example.flowsapp.ui.jugadoresfragment

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
import com.example.flowsapp.domain.modelo.Jugador
import com.example.flowsapp.ui.SwipeGesture
import com.example.flowsapp.ui.loginfragment.LoginAdapter

class JugadoresAdapter(
    val context: Context,
    val actions: JugadoresActions

    ) : ListAdapter<Jugador,JugadoresAdapter.ItemViewholder>(DiffCallback()) {
    interface JugadoresActions {
        fun onDelete(jugadores: Jugador)



    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {

        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.jugador_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) = with(holder) {
        val item = getItem(position)
        bind(item)
    }


    inner class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = JugadorViewBinding.bind(itemView)

        fun bind(item: Jugador) {
            bindViews(item)

        }
        private fun bindViews(jugador: Jugador) {
            with(binding){
                    tvnombre.setText(jugador.nombre)
                    tvId.setText(jugador.id)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Jugador>() {
        override fun areItemsTheSame(oldItem: Jugador, newItem: Jugador): Boolean {
            return oldItem.nombre == newItem.nombre
        }

        override fun areContentsTheSame(oldItem: Jugador, newItem: Jugador): Boolean {
            return oldItem == newItem
        }
    }

}