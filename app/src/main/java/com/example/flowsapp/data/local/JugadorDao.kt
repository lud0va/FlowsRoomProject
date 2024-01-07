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
    fun getAll(): List<JugadorEntity>

    @Insert
    fun add(jugador:JugadorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(jugador: List<JugadorEntity>)

    @Delete
    fun delete(id:Int)
    @Update
    fun update(jugador: JugadorEntity)

    @Delete
    fun deleteAll(jugador: List<JugadorEntity>)

}