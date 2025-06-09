package com.example.weatherapp.di


import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.example.weatherapp.Data.WeatherRepositoryImpl
import com.example.weatherapp.Data.local.WeatherDataSource
import com.example.weatherapp.Data.remote.LocationDatasource
import com.example.weatherapp.Data.remote.WeatherApi
import com.example.weatherapp.MainActivity
import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.usecase.GetCurrentWeather
import com.example.weatherapp.logic.usecase.GetDailyWeather
import com.example.weatherapp.logic.usecase.GetTodayWeather
import com.example.weatherapp.logic.usecase.GetWeatherStatus
import com.example.weatherapp.viewModel.CurrentWeatherViewModel
import com.example.weatherapp.viewModel.StatusValueViewModel
import com.example.weatherapp.viewModel.TodayValueViewModel
import com.example.weatherapp.viewModel.WeatherNextDaysViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { WeatherApi() }
    single { LocationDatasource(get()) }
    // data source
    single { WeatherDataSource(get() , get()) }

    // repository
    single<Repository> { WeatherRepositoryImpl(get()) }

    // use cases
    single { GetCurrentWeather(get()) }
    single { GetDailyWeather(get()) }
    single { GetTodayWeather(get()) }
    single { GetWeatherStatus(get()) }


    viewModel { StatusValueViewModel(get()) }
    viewModel { TodayValueViewModel(get()) }
    viewModel { CurrentWeatherViewModel(get()) }
    viewModel { WeatherNextDaysViewModel(get()) }


}
