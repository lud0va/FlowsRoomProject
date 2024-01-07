package com.example.flowsapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.flowsapp.data.modelo.AutorEntity
import com.example.flowsapp.data.modelo.JuegoEntity

@Dao
interface JuegoDao {
    @Query("Select * FROM juego")
    fun getAll(): List<JuegoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(juego: List<JuegoEntity>)

    @Delete
    fun delete(id:Int)

    @Update
    fun update(juegoEntity: JuegoEntity)

    @Delete
    fun deleteAll(juego: List<JuegoEntity>)
}