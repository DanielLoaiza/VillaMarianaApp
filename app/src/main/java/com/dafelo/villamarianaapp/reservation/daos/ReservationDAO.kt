package com.dafelo.villamarianaapp.reservation.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dafelo.villamarianaapp.reservation.entities.Guest
import com.dafelo.villamarianaapp.reservation.entities.Reservation

@Dao
interface ReservationDAO {

    @Query("SELECT * FROM reservations")
    fun getAll(): List<Reservation>

    @Query("SELECT * FROM reservations WHERE id LIKE :id LIMIT 1")
    fun findById(id: String): Reservation

    @Insert
    fun insertAll(vararg reservations: Reservation)

    @Delete
    fun delete(reservation: Reservation)
}