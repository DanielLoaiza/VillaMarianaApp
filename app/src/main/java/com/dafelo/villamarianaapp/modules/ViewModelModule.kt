package com.dafelo.villamarianaapp.modules

import androidx.lifecycle.ViewModelProvider
import com.dafelo.villamarianaapp.common.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
    
}