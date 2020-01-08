package com.dafelo.villamarianaapp.reservation

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dafelo.villamarianaapp.components.qualifiers.FragmentScope
import java.util.*
import java.util.regex.Pattern.compile
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

    private val emailRegex = compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    private val phoneRegex = compile(
        "(\\\\+\\\\d( )?)?([-\\\\( ]\\\\d{3}[-\\\\) ])( )?\\\\d{3}-\\\\d{4}"
    )


    fun saveReservation() {
        val validations = mutableListOf(
            hasValidDates(),
            hasValidName(),
            hasValidId(),
            hasValidAddress(),
            hasValidInsurance(),
            hasValidEmail(),
            hasValidPhone()
        )

        if (validations.all { it }) {

        } else {
            
        }
    }

    private fun hasValidDates(): Boolean {
        if (startDate.get().isNullOrEmpty() || endDate.get().isNullOrEmpty()) {
            return false
        }
        return true
    }

    private fun hasValidName() = !name.get()?.trim().isNullOrEmpty()

    private fun hasValidId() = !id.get()?.trim().isNullOrEmpty()

    private fun hasValidAddress() = !address.get()?.trim().isNullOrEmpty()

    private fun hasValidInsurance() = !insurance.get()?.trim().isNullOrEmpty()

    private fun hasValidEmail(): Boolean {
        return if (email.get()?.trim().isNullOrEmpty()) {
            false
        } else {
            email.get()?.let { emailRegex.matcher(it).matches() } ?: run { false }

        }
    }

    private fun hasValidPhone(): Boolean {
        return if (phone.get()?.trim().isNullOrEmpty()) {
            false
        } else {
            phone.get()?.let { phoneRegex.matcher(it).matches() } ?: run { false }
        }
    }
}
