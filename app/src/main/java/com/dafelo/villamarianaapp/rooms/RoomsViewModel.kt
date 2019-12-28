package com.dafelo.villamarianaapp.rooms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dafelo.villamarianaapp.components.qualifiers.FragmentScope
import com.dafelo.villamarianaapp.rooms.controllers.RoomReservationController
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@FragmentScope
class RoomsViewModel @Inject constructor(private val roomsReservationController: RoomReservationController) :
    ViewModel() {

    val roomReservations = liveData(Dispatchers.IO) {
        val rooms = roomsReservationController.getRoomReservations()
        emit(rooms)
    }
}