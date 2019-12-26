package com.dafelo.villamarianaapp.components

import android.content.Context
import com.dafelo.villamarianaapp.MainActivity
import com.dafelo.villamarianaapp.components.qualifiers.ApplicationContext
import com.dafelo.villamarianaapp.modules.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DatabaseModule::class])
@Singleton
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        // Takes an instance of AppComponent when creating
        // an instance of LoginComponent
        fun create(@ApplicationContext @BindsInstance appContext: Context): ApplicationComponent
    }
}