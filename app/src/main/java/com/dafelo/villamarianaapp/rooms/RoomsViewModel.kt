package com.dafelo.villamarianaapp.rooms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dafelo.villamarianaapp.components.qualifiers.ActivityScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@ActivityScope
class RoomsViewModel @Inject constructor(private val roomRepository: RoomRepository) : ViewModel() {

    val rooms = liveData(Dispatchers.IO) {
        val rooms = roomRepository.getAllRooms()
        emit(rooms)
    }
}