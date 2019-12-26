package com.dafelo.villamarianaapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dafelo.villamarianaapp.reservation.daos.GuestDAO
import com.dafelo.villamarianaapp.reservation.daos.ReservationDAO
import com.dafelo.villamarianaapp.reservation.daos.RoomDAO
import com.dafelo.villamarianaapp.reservation.entities.Guest
import com.dafelo.villamarianaapp.reservation.entities.Reservation
import com.dafelo.villamarianaapp.reservation.entities.Room

@Database(entities = [Guest::class, Room::class, Reservation::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun guestDAO(): GuestDAO
    abstract fun roomDAO(): RoomDAO
    abstract fun reservationDAO(): ReservationDAO
}