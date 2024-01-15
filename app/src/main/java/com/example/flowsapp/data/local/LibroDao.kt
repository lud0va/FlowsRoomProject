package com.example.flowsapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.flowsapp.data.modelo.AutorEntity
import com.example.flowsapp.data.modelo.LibroEntity
@Dao
interface LibroDao {

    @Query("Select * FROM libro")
    suspend fun getAll(): List<LibroEntity>

    @Query("Select * FROM libro WHERE idautor= :idautor")
    suspend   fun getLibro(idautor:Int):List<LibroEntity>
    @Insert
    suspend fun insert(libro:LibroEntity)

    @Update
    suspend  fun update(libro: LibroEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAll(movies: List<LibroEntity>)

    @Delete
    suspend  fun delete(libro: LibroEntity)

    @Delete
    suspend fun deleteAll(libros: List<LibroEntity>)
}