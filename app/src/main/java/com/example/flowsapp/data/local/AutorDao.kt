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
interface AutorDao {

    @Query("Select * FROM autor")
    fun getAll(): List<AutorEntity>

    @Query("Select * FROM autor WHERE id=id")
    fun getAutor(id:Int):AutorEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<AutorEntity>)

    @Delete
    fun delete(aitpr: AutorEntity)
    @Update
    fun update(autorEntity: AutorEntity)
    @Delete
    fun deleteAll(autor: List<AutorEntity>)
}