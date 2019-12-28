package com.dafelo.villamarianaapp.components

import com.dafelo.villamarianaapp.components.qualifiers.FragmentScope
import com.dafelo.villamarianaapp.modules.RoomViewModelModule
import com.dafelo.villamarianaapp.rooms.RoomFragment
import dagger.Subcomponent

@Subcomponent(modules = [RoomViewModelModule::class])
@FragmentScope
interface RoomComponent {
    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): RoomComponent
    }

    fun inject(roomFragment: RoomFragment)
}