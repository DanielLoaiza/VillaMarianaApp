package com.dafelo.villamarianaapp.components

import dagger.Module

@Module(subcomponents = [ReservationSubComponent::class, RoomComponent::class])
class SubcomponentsModule