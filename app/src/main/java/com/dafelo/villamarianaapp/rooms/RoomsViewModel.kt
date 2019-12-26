package com.dafelo.villamarianaapp.rooms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dafelo.villamarianaapp.components.qualifiers.ActivityScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScope
class RoomsViewModel @Inject constructor(private val roomRepository: RoomRepository): ViewModel() {

    suspend fun loadRooms() {
        viewModelScope.launch {
            with(Dispatchers.IO) {
                val rooms = roomRepository.getAllRooms()
                rooms.size
            }
        }
    }
}