package com.example.flowsapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.flowsapp.data.modelo.JugadorEntity
import com.example.flowsapp.domain.modelo.Jugador

@Dao
interface JugadorDao {
    @Query("Select * FROM jugador")
    suspend   fun getAll(): List<JugadorEntity>

    @Insert
    suspend  fun add(jugador:JugadorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAll(jugador: List<JugadorEntity>)

    @Delete
    suspend fun delete(jugador: JugadorEntity)
    @Update
    suspend   fun update(jugador: JugadorEntity)

    @Delete
    suspend fun deleteAll(jugador: List<JugadorEntity>)

}