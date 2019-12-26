package com.dafelo.villamarianaapp.components

import com.dafelo.villamarianaapp.MainActivity
import com.dafelo.villamarianaapp.components.qualifiers.ActivityScope
import com.dafelo.villamarianaapp.modules.ReservationViewModelModule
import com.dafelo.villamarianaapp.rooms.RoomFragment
import dagger.Subcomponent

@Subcomponent(modules = [ReservationViewModelModule::class])
@ActivityScope
interface ReservationComponent {
    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): ReservationComponent
    }

    fun inject(loginActivity: MainActivity)
    fun inject(roomFragment: RoomFragment)
}