package com.addam.modularandroidtest.feature.pokemon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.addam.modularandroidtest.R
import com.addam.modularandroidtest.databinding.ActivityPokemonBinding
import com.addam.modularandroidtest.di.modules.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class PokemonActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    lateinit var viewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        viewModel = ViewModelProvider(this, factory)[PokemonViewModel::class.java]

        val binding: ActivityPokemonBinding = DataBindingUtil.setContentView(this, R.layout.activity_pokemon)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

    }
}