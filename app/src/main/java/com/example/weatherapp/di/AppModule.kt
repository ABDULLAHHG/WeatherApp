package com.example.weatherapp.di


import com.example.weatherapp.viewModel.StatusValueViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { StatusValueViewModel() }
}
