package com.dafelo.villamarianaapp.components

import com.dafelo.villamarianaapp.components.qualifiers.FragmentScope
import com.dafelo.villamarianaapp.modules.ReservationViewModelModule
import com.dafelo.villamarianaapp.reservation.ReservationFragment
import dagger.Subcomponent

@Subcomponent(modules = [ReservationViewModelModule::class])
@FragmentScope
interface ReservationSubComponent {
    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): ReservationSubComponent
    }

    fun inject(reservationFragment: ReservationFragment)
}