package com.dafelo.villamarianaapp.reservation.entities

import androidx.room.*
import com.dafelo.villamarianaapp.database.converters.DateConverter
import java.util.*

@Entity(
    tableName = "reservations", foreignKeys = [
        ForeignKey(
            entity = Guest::class,
            parentColumns = ["id"],
            childColumns = ["mainGuest"]
        ), ForeignKey(
            entity = Room::class,
            parentColumns = ["number"],
            childColumns = ["room"]
        )]
)
@TypeConverters(DateConverter::class)
data class Reservation(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "start_date") val startDate: Date,
    @ColumnInfo(name = "end_date") val endDate: Date,
    @ColumnInfo(name = "guests_quantity") val guestsQuantity: Int,
    val mainGuest: String,
    val room: Int
)