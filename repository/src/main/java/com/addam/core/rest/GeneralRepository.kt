package com.addam.core.rest

import com.addam.core.model.SampleLoginResponse
import io.reactivex.Single

/**
 * Created by addam on 11/19/20
 */
class GeneralRepository(private val api: GeneralService) {

    fun getLogin(): Single<SampleLoginResponse> = api.getSampleLogin()
}