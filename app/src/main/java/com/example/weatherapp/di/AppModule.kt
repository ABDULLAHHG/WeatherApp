package com.example.weatherapp.di


import com.example.weatherapp.Data.WeatherRepositoryImpl
import com.example.weatherapp.Data.local.WeatherDataSource
import com.example.weatherapp.Data.remote.WeatherApi
import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.usecase.GetCurrentWeather
import com.example.weatherapp.logic.usecase.GetDailyWeather
import com.example.weatherapp.logic.usecase.GetTodayWeather
import com.example.weatherapp.logic.usecase.GetWeatherStatus
import com.example.weatherapp.viewModel.CurrentWeatherViewModel
import com.example.weatherapp.viewModel.StatusValueViewModel
import com.example.weatherapp.viewModel.TodayValueViewModel
import com.example.weatherapp.viewModel.WeatherNextDaysViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    //
    single{WeatherApi()}

    // data source
    single { WeatherDataSource(get()) }

    // repository
    single<Repository>{ WeatherRepositoryImpl(get()) }

    // use cases
    single{GetCurrentWeather(get())}
    single{ GetDailyWeather(get()) }
    single { GetTodayWeather(get()) }
    single { GetWeatherStatus(get()) }


    viewModel { StatusValueViewModel(get()) }
    viewModel { TodayValueViewModel(get()) }
    viewModel { CurrentWeatherViewModel(get()) }
    viewModel { WeatherNextDaysViewModel(get()) }



}
