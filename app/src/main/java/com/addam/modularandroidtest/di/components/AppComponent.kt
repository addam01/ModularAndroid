package com.addam.modularandroidtest.di.components

import android.app.Application
import com.addam.core.NetworkModule
import com.addam.data.DatabaseModule
import com.addam.modularandroidtest.ModularAndroidApplication
import com.addam.modularandroidtest.di.modules.ActivityBuilder
import com.addam.modularandroidtest.di.modules.AppModule
import com.addam.modularandroidtest.di.modules.ViewModelFactoryModules
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by addam on 11/20/20
 */

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class),
    (NetworkModule::class), (ActivityBuilder::class), (ViewModelFactoryModules::class),
    (DatabaseModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }
        fun inject(app: ModularAndroidApplication)
}