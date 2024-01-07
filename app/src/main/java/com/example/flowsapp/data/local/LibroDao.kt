package com.example.flowsapp.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.flowsapp.data.modelo.AutorEntity
import com.example.flowsapp.data.modelo.LibroEntity

interface LibroDao {

    @Query("Select * FROM libro")
    fun getAll(): List<LibroEntity>

    @Query("Select * FROM libro WHERE id=id")
    fun getLibro(id:Int):LibroEntity
    @Insert
    fun insert(libro:LibroEntity)

    @Update
    fun update(libro: LibroEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<LibroEntity>)

    @Delete
    fun delete(libro: LibroEntity)

    @Delete
    fun deleteAll(libros: List<LibroEntity>)
}