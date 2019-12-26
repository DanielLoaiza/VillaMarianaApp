package com.dafelo.villamarianaapp.reservation.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dafelo.villamarianaapp.reservation.entities.Guest
import com.dafelo.villamarianaapp.reservation.entities.Room

@Dao
interface RoomDAO {

    @Query("SELECT * FROM rooms")
    fun getAll(): List<Room>

    @Insert
    fun insertAll(vararg room: Room)
}