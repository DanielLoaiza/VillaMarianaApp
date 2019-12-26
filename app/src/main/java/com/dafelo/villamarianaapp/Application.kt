package com.dafelo.villamarianaapp

import android.app.Application
import com.dafelo.villamarianaapp.components.ApplicationComponent
import com.dafelo.villamarianaapp.components.DaggerApplicationComponent

class Application : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        applicationComponent = DaggerApplicationComponent
            .factory()
            .create(this)

        super.onCreate()
    }
}