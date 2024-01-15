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
   suspend fun getAll(): List<AutorEntity>

    @Query("Select * FROM autor WHERE id= :id")
    suspend   fun getAutor(id:Int):AutorEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend   fun insertAll(autor: List<AutorEntity>)

 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend   fun insert(autorEntity: AutorEntity)

 @Delete
    suspend  fun delete(aitpr: AutorEntity)
    @Update
    suspend  fun update(autorEntity: AutorEntity)
    @Delete
    suspend fun deleteAll(autor: List<AutorEntity>)
}