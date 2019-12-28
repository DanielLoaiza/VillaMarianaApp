package com.dafelo.villamarianaapp.modules

import androidx.lifecycle.ViewModel
import com.dafelo.villamarianaapp.components.qualifiers.ViewModelKey
import com.dafelo.villamarianaapp.rooms.RoomsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class RoomViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RoomsViewModel::class)
    internal abstract fun roomsViewModel(viewModel: RoomsViewModel): ViewModel
}