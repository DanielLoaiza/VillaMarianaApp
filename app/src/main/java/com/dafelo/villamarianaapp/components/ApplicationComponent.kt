package com.dafelo.villamarianaapp.components

import android.content.Context
import com.dafelo.villamarianaapp.components.qualifiers.ApplicationContext
import com.dafelo.villamarianaapp.database.AppDatabase
import com.dafelo.villamarianaapp.modules.DatabaseModule
import com.dafelo.villamarianaapp.reservation.daos.ReservationDAO
import com.dafelo.villamarianaapp.reservation.daos.RoomDAO
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DatabaseModule::class])
@Singleton
interface ApplicationComponent {

    fun database(): AppDatabase

    fun reservationDAO(): ReservationDAO

    fun roomDAO(): RoomDAO

    @Component.Factory
    interface Factory {
        // Takes an instance of AppComponent when creating
        // an instance of LoginComponent
        fun create(@ApplicationContext @BindsInstance appContext: Context): ApplicationComponent
    }
}