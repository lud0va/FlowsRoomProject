package com.example.flows.di

import android.content.Context
import androidx.room.Room
import com.example.flowsapp.data.local.AppDatabase
import com.example.flowsapp.data.local.AutorDao
import com.example.flowsapp.data.local.JuegoDao
import com.example.flowsapp.data.local.JugadorDao
import com.example.flowsapp.data.local.LibroDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.android.qualifiers.ApplicationContext

import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app.db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideAutorDao(appDatabase: AppDatabase): AutorDao {
        return appDatabase.autorDao()
    }
    @Provides
    fun provideJuegoDao(appDatabase: AppDatabase): JuegoDao {
        return appDatabase.juegoDao()
    }
    @Provides
    fun provideJugadorDao(appDatabase: AppDatabase):JugadorDao{
        return appDatabase.jugadorDao()
    }
    @Provides
    fun provideLibroDao(appDatabase: AppDatabase): LibroDao{
        return appDatabase.libroDao()
    }


}