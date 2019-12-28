package com.dafelo.villamarianaapp.components

import com.dafelo.villamarianaapp.MainActivity
import com.dafelo.villamarianaapp.components.qualifiers.ActivityScope
import com.dafelo.villamarianaapp.modules.ReservationViewModelModule
import com.dafelo.villamarianaapp.reservation.ReservationFragment
import com.dafelo.villamarianaapp.rooms.RoomFragment
import dagger.Component
import dagger.Subcomponent

@Component(dependencies = [ApplicationComponent::class], modules = [SubcomponentsModule::class])
@ActivityScope
interface ReservationComponent {

    fun reservationComponent(): ReservationSubComponent.Factory
    fun roomComponent(): RoomComponent.Factory
    // Factory that is used to create instances of this component
    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): ReservationComponent
    }

    fun inject(loginActivity: MainActivity)
}