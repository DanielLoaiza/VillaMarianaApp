package com.dafelo.villamarianaapp.components

import android.content.Context
import com.dafelo.villamarianaapp.components.qualifiers.ApplicationContext
import com.dafelo.villamarianaapp.modules.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DatabaseModule::class, SubcomponentsModule::class])
@Singleton
interface ApplicationComponent {
    // This function exposes the LoginComponent Factory out of the graph so consumers
// can use it to obtain new instances of LoginComponent
    fun reservationComponent(): ReservationComponent.Factory

    @Component.Factory
    interface Factory {
        // Takes an instance of AppComponent when creating
        // an instance of LoginComponent
        fun create(@ApplicationContext @BindsInstance appContext: Context): ApplicationComponent
    }
}