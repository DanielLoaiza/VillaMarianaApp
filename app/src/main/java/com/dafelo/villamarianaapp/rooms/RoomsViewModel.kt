package com.dafelo.villamarianaapp.rooms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dafelo.villamarianaapp.components.qualifiers.ActivityScope
import com.dafelo.villamarianaapp.rooms.controllers.RoomReservationController
import com.dafelo.villamarianaapp.rooms.repositories.RoomRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@ActivityScope
class RoomsViewModel @Inject constructor(private val roomsReservationController: RoomReservationController) : ViewModel() {

    val roomReservations = liveData(Dispatchers.IO) {
        val rooms = roomsReservationController.getRoomReservations()
        emit(rooms)
    }
}