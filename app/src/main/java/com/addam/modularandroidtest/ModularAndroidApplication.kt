package com.addam.modularandroidtest

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.addam.modularandroidtest.di.components.DaggerAppComponent
import com.github.ajalt.timberkt.Timber
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by addam on 11/20/20
 */
open class ModularAndroidApplication: Application(), HasAndroidInjector, LifecycleObserver {

    @Inject
    lateinit var activityDispatcher: DispatchingAndroidInjector<Any>

    companion object{
        @get:Synchronized
        lateinit var instance: ModularAndroidApplication
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return activityDispatcher
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        instance = this
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

//        appComponents.inject(this)
    }
}