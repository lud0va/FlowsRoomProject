package com.example.flowsapp.ui.autoresfragment.detalle

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
import com.example.flowsapp.domain.modelo.Libro
import com.example.flowsapp.ui.SwipeGesture
import com.example.flowsapp.ui.autoresfragment.AutoresAdapter

class AutorAdapter(
    val context: Context,
    val actions: AutorAdapter.AutorActions,


) : ListAdapter<Libro, AutorAdapter.ItemViewholder>(AutorAdapter.DiffCallback()) { interface AutorActions {
    fun onDelete(libro: Libro)


}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {

        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.libro_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) = with(holder) {
        val item = getItem(position)
        bind(item)
    }


    inner class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = JugadorViewBinding.bind(itemView)

        fun bind(item: Libro) {

            bindViews(item)

        }

        private fun bindViews(libro: Libro) {
            with(binding) {
                tvnombre.text = libro.libro
                tvId.text = libro.id.toString()
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Libro>() {
        override fun areItemsTheSame(oldItem: Libro, newItem: Libro): Boolean {
            return oldItem.libro == newItem.libro
        }

        override fun areContentsTheSame(oldItem: Libro, newItem: Libro): Boolean {
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