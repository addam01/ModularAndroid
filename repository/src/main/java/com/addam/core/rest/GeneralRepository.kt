package com.addam.core.rest

import com.addam.core.model.PokemonSpeciesResponse
import com.addam.core.model.SampleLoginResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by addam on 11/19/20
 */
@Singleton
class GeneralRepository @Inject constructor(private val api: GeneralService) {

    fun getLogin(): Single<SampleLoginResponse> = api.getSampleLogin()

    fun getPokemon(name: String): Single<PokemonSpeciesResponse> = api.getPokemon(name)
}