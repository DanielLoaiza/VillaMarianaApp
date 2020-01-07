package com.dafelo.villamarianaapp.reservation

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dafelo.villamarianaapp.components.qualifiers.FragmentScope
import javax.inject.Inject

@FragmentScope
class ReservationViewModel @Inject constructor() : ViewModel() {

    val startDate = ObservableField("")
    val endDate = ObservableField("")
    val name = ObservableField("")
    val id = ObservableField("")
    val address = ObservableField("")
    val insurance = ObservableField("")
    val email = ObservableField("")
    val phone = ObservableField("")

    fun saveReservation() {}
}
