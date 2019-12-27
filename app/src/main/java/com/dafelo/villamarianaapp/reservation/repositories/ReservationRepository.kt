package com.dafelo.villamarianaapp.reservation.repositories

import com.dafelo.villamarianaapp.components.qualifiers.ActivityScope
import com.dafelo.villamarianaapp.reservation.daos.ReservationDAO
import com.dafelo.villamarianaapp.reservation.daos.RoomDAO
import com.dafelo.villamarianaapp.reservation.entities.Reservation
import com.dafelo.villamarianaapp.reservation.entities.Room
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@ActivityScope
class ReservationRepository @Inject constructor(private val reservationDAO : ReservationDAO) {

    suspend fun getAllReservations(): List<Reservation> {

        return coroutineScope {
            async {
                reservationDAO.getAll()
            }
        }.await()
    }
}