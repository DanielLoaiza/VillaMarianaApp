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
    suspend fun getAll(): List<Room>

    @Insert
    suspend fun insertAll(vararg room: Room)
}