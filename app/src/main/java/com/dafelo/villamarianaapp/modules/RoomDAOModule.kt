package com.dafelo.villamarianaapp.modules

import com.dafelo.villamarianaapp.database.AppDatabase
import com.dafelo.villamarianaapp.reservation.daos.RoomDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomDAOModule {

    @Provides
    @Singleton
    fun roomDAOModule(appDatabase: AppDatabase): RoomDAO {
        return appDatabase.roomDAO()
    }
}