package com.addam.modularandroidtest.di.modules

import com.addam.modularandroidtest.feature.login.LoginActivity
import com.addam.modularandroidtest.feature.pokemon.PokemonActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by addam on 11/20/20
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    internal abstract fun bindPokemonActivity(): PokemonActivity
}