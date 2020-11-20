package com.addam.modularandroidtest

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.addam.modularandroidtest.di.components.AppComponents
import com.addam.modularandroidtest.di.components.DaggerAppComponents
import com.github.ajalt.timberkt.Timber
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by addam on 11/20/20
 */
open class ModularAndroidApplication: Application(), HasAndroidInjector, LifecycleObserver {

    companion object{
        lateinit var instance: ModularAndroidApplication
    }

    @Inject
    lateinit var activityDispatcher: DispatchingAndroidInjector<Any>

    lateinit var appComponents: AppComponents

    override fun androidInjector(): AndroidInjector<Any> {
        return activityDispatcher
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        appComponents = DaggerAppComponents
            .builder()
            .application(this)
            .context(this)
            .build()

//        appComponents.inject(this)
    }
}