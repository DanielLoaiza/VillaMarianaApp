package com.dafelo.villamarianaapp.reservation.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dafelo.villamarianaapp.reservation.entities.Guest

@Dao
interface GuestDAO {

    @Query("SELECT * FROM guests")
    fun getAll(): List<Guest>

    @Query("SELECT * FROM guests WHERE id LIKE :id LIMIT 1")
    fun findById(id: String): Guest

    @Insert
    fun insertAll(vararg guests: Guest)

    @Delete
    fun delete(guest: Guest)
}