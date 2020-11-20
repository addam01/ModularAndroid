package com.addam.modularandroidtest.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by addam on 11/20/20
 */
@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ViewModelKey (
    val value: KClass<out ViewModel>
)