package com.addam.modularandroidtest.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.addam.modularandroidtest.di.ViewModelKey
import com.addam.modularandroidtest.feature.login.LoginViewModel
import com.addam.modularandroidtest.feature.pokemon.PokemonViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by addam on 11/20/20
 */
@Module
abstract class ViewModelFactoryModules {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory):
            ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun provideLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PokemonViewModel::class)
    internal abstract fun providePokemonViewModel(viewModel: PokemonViewModel): ViewModel
}