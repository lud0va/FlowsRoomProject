package com.example.flowsapp.ui.loginfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.flowsapp.R
import com.example.flowsapp.databinding.LoginViewBinding
import com.example.flowsapp.domain.modelo.Usuario

class LoginAdapter:ListAdapter<Usuario,LoginAdapter.ItemViewholder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {

        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.login_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) = with(holder) {
        val item = getItem(position)
    }


    inner class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = LoginViewBinding.bind(itemView)


    }


    class DiffCallback : DiffUtil.ItemCallback<Usuario>() {
        override fun areItemsTheSame(oldItem: Usuario, newItem: Usuario): Boolean {
            return oldItem== newItem
        }

        override fun areContentsTheSame(oldItem: Usuario, newItem: Usuario): Boolean {
            return oldItem == newItem
        }

    }
}