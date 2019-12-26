package com.dafelo.villamarianaapp.rooms

import com.dafelo.villamarianaapp.components.qualifiers.ActivityScope
import com.dafelo.villamarianaapp.reservation.daos.RoomDAO
import com.dafelo.villamarianaapp.reservation.entities.Room
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@ActivityScope
class RoomRepository @Inject constructor(private val roomDAO: RoomDAO) {

    suspend fun getAllRooms(): List<Room> {

        return coroutineScope {
            async {
                roomDAO.getAll()
            }
        }.await()
    }
}