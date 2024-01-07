package com.example.flowsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flowsapp.domain.modelo.Autor
import com.example.flowsapp.domain.modelo.Juego
import com.example.flowsapp.domain.modelo.Jugador
import com.example.flowsapp.domain.modelo.Libro

@Database(entities = [Autor::class,Libro::class,Jugador::class, Juego::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun autorDao(): AutorDao
    abstract  fun libroDao():LibroDao
    abstract fun juegoDao():JuegoDao
    abstract fun jugadorDao():JugadorDao
}
