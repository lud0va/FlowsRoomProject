package com.example.flowsapp.data.modelo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.flowsapp.domain.modelo.Autor
import com.example.flowsapp.domain.modelo.Libro

@Entity(tableName = "libro",
    foreignKeys = [
        ForeignKey(entity = AutorEntity::class,
            parentColumns = ["id"],
            childColumns = ["idautor"])
    ],
    indices = [Index("idautor")]
)

data class LibroEntity (
    @NonNull
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo("idautor")
    val idAutor:Int,
    @ColumnInfo("nombre")
    val libro:String

)
fun Libro.toEntity():LibroEntity=LibroEntity(id,idAutor, libro)