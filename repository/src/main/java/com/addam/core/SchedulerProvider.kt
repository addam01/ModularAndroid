package com.addam.core

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single


/**
 * Created by addam on 11/19/20
 */
class SchedulerProvider(private val backgroundScheduler: Scheduler, private val foregroundScheduler: Scheduler) {
    fun <T> getSchedulersForSingle(): (Single<T>) -> Single<T> {
        return { single: Single<T> ->
            single.subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
        }
    }
}