package com.dafelo.villamarianaapp.components.qualifiers

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Qualifier
import javax.inject.Scope
import kotlin.reflect.KClass

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
