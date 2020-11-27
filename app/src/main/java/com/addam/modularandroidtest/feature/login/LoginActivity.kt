package com.addam.modularandroidtest.feature.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.addam.modularandroidtest.R
import com.addam.modularandroidtest.databinding.ActivityLoginBinding
import com.addam.modularandroidtest.di.modules.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = viewModel

        setupEvents()
    }

    private fun setupEvents() {
        viewModel.data.observe(this,
            { t ->
//                Toast.makeText(this@LoginActivity, t!!.username, Toast.LENGTH_SHORT).show()
                viewModel.setUser(t.username, t.password)
            })

        viewModel.callbackObservable.observe(this, { t->
            Toast.makeText(this@LoginActivity, t, Toast.LENGTH_SHORT).show()
        })
    }
}