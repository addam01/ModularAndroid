package com.addam.core.rest

import com.addam.core.model.SampleLoginResponse
import io.reactivex.rxjava3.core.Single

import retrofit2.http.GET

/**
 * Created by addam on 11/19/20
 */
interface GeneralService {

    @GET("login")
    fun getSampleLogin(): Single<SampleLoginResponse>
}