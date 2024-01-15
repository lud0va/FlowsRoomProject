package com.example.flowsapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flowsapp.data.modelo.AutorEntity
import com.example.flowsapp.data.modelo.JuegoEntity
import com.example.flowsapp.data.modelo.JugadorEntity
import com.example.flowsapp.data.modelo.LibroEntity
import com.example.flowsapp.domain.modelo.Autor
import com.example.flowsapp.domain.modelo.Juego
import com.example.flowsapp.domain.modelo.Jugador
import com.example.flowsapp.domain.modelo.Libro

@Database(entities = [AutorEntity::class,LibroEntity::class,JugadorEntity::class, JuegoEntity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun autorDao(): AutorDao
    abstract  fun libroDao():LibroDao
    abstract fun juegoDao():JuegoDao
    abstract fun jugadorDao():JugadorDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "item_database"
                )
                    .createFromAsset("database/app.db")
                    .fallbackToDestructiveMigrationFrom(4)
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
