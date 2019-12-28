package com.dafelo.villamarianaapp.modules

import android.content.Context
import androidx.room.Room
import com.dafelo.villamarianaapp.components.qualifiers.ApplicationContext
import com.dafelo.villamarianaapp.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RoomDAOModule::class, ReservationDAOModule::class])
class DatabaseModule {

    @Provides
    @Singleton
    fun appDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "villa-mariana.db"
        ).createFromAsset("database/villa-mariana.db").build()
    }
}