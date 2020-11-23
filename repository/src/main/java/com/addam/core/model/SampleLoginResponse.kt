package com.addam.core.model

import com.google.gson.annotations.SerializedName

/**
 * Created by addam on 11/19/20
 */
data class SampleLoginResponse(
    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String
)