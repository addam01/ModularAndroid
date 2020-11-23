package com.addam.modularandroidtest.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by addam on 11/23/20
 *
 * All resource provider for App module goes here
 */
@Module
class AppModule {
    @Provides
    @Singleton
    fun getContext(application: Application): Context {
        return application
    }
}