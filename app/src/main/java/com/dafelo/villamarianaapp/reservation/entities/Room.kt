package com.dafelo.villamarianaapp.reservation.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rooms")
data class Room(
    @PrimaryKey val number: Int
)