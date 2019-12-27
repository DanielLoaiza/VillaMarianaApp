package com.dafelo.villamarianaapp.modules

import com.dafelo.villamarianaapp.database.AppDatabase
import com.dafelo.villamarianaapp.reservation.daos.ReservationDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReservationDAOModule {

    @Provides
    @Singleton
    fun reservationDAOModule(appDatabase: AppDatabase): ReservationDAO {
        return appDatabase.reservationDAO()
    }
}