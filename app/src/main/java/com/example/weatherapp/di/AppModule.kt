package com.example.weatherapp.di


import com.example.weatherapp.Data.local.WeatherDataSource
import com.example.weatherapp.Data.remote.WeatherApi
import com.example.weatherapp.Data.repository.WeatherRepositoryImpl
import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.usecase.GetCurrentWeather
import com.example.weatherapp.logic.usecase.GetDailyWeather
import com.example.weatherapp.logic.usecase.GetTodayHourlyTheme
import com.example.weatherapp.logic.usecase.GetTodayHourlyWeather
import com.example.weatherapp.logic.usecase.GetWeatherStatus
import com.example.weatherapp.presentation.viewModel.CurrentWeatherViewModel
import com.example.weatherapp.presentation.viewModel.TodayHourlyThemeViewModel
import com.example.weatherapp.presentation.viewModel.TodayHourlyWeatherViewModel
import com.example.weatherapp.presentation.viewModel.WeatherNextDaysViewModel
import com.example.weatherapp.presentation.viewModel.WeatherStatusViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    //
    single { WeatherApi() }

    // data source
    single { WeatherDataSource(get()) }

    // repository
    single<Repository> { WeatherRepositoryImpl(get()) }

    // use cases
    single { GetCurrentWeather(get()) }
    single { GetDailyWeather(get()) }
    single { GetTodayHourlyWeather(get()) }
    single { GetWeatherStatus(get()) }
    single { GetTodayHourlyTheme(get()) }

    viewModel { WeatherStatusViewModel(get()) }
    viewModel { TodayHourlyWeatherViewModel(get()) }
    viewModel { CurrentWeatherViewModel(get()) }
    viewModel { WeatherNextDaysViewModel(get()) }
    viewModel { TodayHourlyThemeViewModel(get()) }


}
