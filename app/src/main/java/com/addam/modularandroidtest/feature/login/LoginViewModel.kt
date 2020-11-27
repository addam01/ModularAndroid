package com.addam.modularandroidtest.feature.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.addam.core.SchedulerProvider
import com.addam.core.model.SampleLoginResponse
import com.addam.core.rest.GeneralRepository
import com.addam.data.models.User
import com.addam.data.repositories.UserRepository
import com.addam.modularandroidtest.common.ObservableString
import com.github.ajalt.timberkt.Timber
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by addam on 11/20/20
 */
class LoginViewModel @Inject constructor(private val generalRepository: GeneralRepository,
                                         private val schedulerProvider: SchedulerProvider,
                                         private val userRepository: UserRepository): ViewModel() {

    val username = ObservableString("")
    val password = ObservableString("")

    var data = MutableLiveData<SampleLoginResponse>()
    var callbackObservable = MutableLiveData<String>()

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

    fun setUser(username: String, password: String){

        userRepository.insertUser(User(username, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onComplete = {
                            callbackObservable.postValue("Data written")
                        },
                        onError = {
                            Timber.e(it)
                        }
                ).addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}