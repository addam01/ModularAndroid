package com.addam.modularandroidtest.feature.pokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.addam.core.SchedulerProvider
import com.addam.core.model.PokemonSpeciesResponse
import com.addam.core.rest.GeneralRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

/**
 * Created by addam on 12/3/20
 */
class PokemonViewModel @Inject constructor(private val generalRepository: GeneralRepository, private val schedulerProvider: SchedulerProvider): ViewModel() {

    val pokemonName = MutableLiveData<String>()
    val pokemonDesc = MutableLiveData("")

    fun onSearchClicked(){
        getPokemon()
            .subscribeBy(
                onSuccess = {
                    pokemonDesc.value = it.flavor_text_entries[1].flavor_text
                },
                onError = {
                    pokemonDesc.value = it.message
                }
            )
    }

    private fun getPokemon(): Single<PokemonSpeciesResponse>
    = generalRepository.getPokemon(pokemonName.value!!)
        .compose(schedulerProvider.getSchedulersForSingle())
}