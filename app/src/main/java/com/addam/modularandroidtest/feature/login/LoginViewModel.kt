package com.addam.modularandroidtest.feature.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.addam.core.SchedulerProvider
import com.addam.core.model.SampleLoginResponse
import com.addam.core.rest.GeneralRepository
import com.addam.modularandroidtest.common.ObservableString
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

/**
 * Created by addam on 11/20/20
 */
class LoginViewModel @Inject constructor(private val generalRepository: GeneralRepository,
                                         private val schedulerProvider: SchedulerProvider): ViewModel() {

    val username = ObservableString("")
    val password = ObservableString("")

    var data = MutableLiveData<SampleLoginResponse>()

    private val compositeDisposable = CompositeDisposable()

    fun onLoginClicked(){
        getLogin()
            .subscribeBy(
                onSuccess = {
                    data.postValue(it)
                },
                onError = {

                }
            ).addTo(compositeDisposable)
    }

    private fun getLogin(): Single<SampleLoginResponse>
     = generalRepository.getLogin()
        .compose(schedulerProvider.getSchedulersForSingle())

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}