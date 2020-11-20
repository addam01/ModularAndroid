package com.addam.modularandroidtest.di.components

import android.app.Application
import android.content.Context
import com.addam.core.NetworkModule
import com.addam.modularandroidtest.di.modules.ActivityBuilder
import com.addam.modularandroidtest.di.modules.ViewModelFactoryModules
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by addam on 11/20/20
 */

@Singleton
@Component(modules = [NetworkModule::class, ActivityBuilder::class, ViewModelFactoryModules::class])
interface AppComponents {

//    fun inject(application: ModularAndroidApplication)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponents
    }
}