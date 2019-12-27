package com.dafelo.villamarianaapp.rooms.entities

import java.util.*

data class RoomReservationInfo(
    val isInUse: Boolean,
    val reserveOvertime: Boolean,
    val roomNumber: Int,
    val guestName: String = "",
    val startDate: Date? = null,
    val endDate: Date? = null
)