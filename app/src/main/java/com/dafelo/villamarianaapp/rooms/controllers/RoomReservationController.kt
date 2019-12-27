package com.dafelo.villamarianaapp.rooms.controllers

import com.dafelo.villamarianaapp.components.qualifiers.ActivityScope
import com.dafelo.villamarianaapp.reservation.repositories.ReservationRepository
import com.dafelo.villamarianaapp.rooms.entities.RoomReservationInfo
import com.dafelo.villamarianaapp.rooms.repositories.RoomRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@ActivityScope
class RoomReservationController @Inject constructor(
    private val roomRepository: RoomRepository,
    private val reservationRepository: ReservationRepository
) {
    suspend fun getRoomReservations(): List<RoomReservationInfo> {
        return coroutineScope {
            val roomsRequest = async { roomRepository.getAllRooms() }
            val reservationsRequest = async { reservationRepository.getAllReservations() }

            val rooms = roomsRequest.await()
            val reservations = reservationsRequest.await()

            val currentReservedRooms = reservations.map { it.room to it }.toMap()

            return@coroutineScope rooms.map {
                RoomReservationInfo(
                    isInUse = currentReservedRooms.contains(it.number),
                    reserveOvertime = false,
                    roomNumber = it.number,
                    guestName = currentReservedRooms[it.number]?.mainGuest.orEmpty(),
                    startDate = currentReservedRooms[it.number]?.startDate,
                    endDate = currentReservedRooms[it.number]?.endDate

                )
            }

        }
    }
}