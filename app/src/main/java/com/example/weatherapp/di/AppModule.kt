package com.example.weatherapp.di


import android.location.Geocoder
import com.example.weatherapp.data.local.WeatherDataSource
import com.example.weatherapp.data.remote.LocationDataSource
import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.data.repository.LocationRepositoryImpl
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.logic.reposiotry.LocationRepository
import com.example.weatherapp.logic.reposiotry.WeatherRepository
import com.example.weatherapp.logic.usecase.GetCurrentWeather
import com.example.weatherapp.logic.usecase.GetDailyWeather
import com.example.weatherapp.logic.usecase.GetLocationUseCase
import com.example.weatherapp.logic.usecase.GetTodayHourlyTheme
import com.example.weatherapp.logic.usecase.GetTodayHourlyWeather
import com.example.weatherapp.logic.usecase.GetWeatherStatus
import com.example.weatherapp.presentation.viewModel.CurrentWeatherViewModel
import com.example.weatherapp.presentation.viewModel.LocationViewModel
import com.example.weatherapp.presentation.viewModel.TodayHourlyThemeViewModel
import com.example.weatherapp.presentation.viewModel.TodayHourlyWeatherViewModel
import com.example.weatherapp.presentation.viewModel.WeatherNextDaysViewModel
import com.example.weatherapp.presentation.viewModel.WeatherStatusViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.Locale

val appModule = module {


    // Api
    single { WeatherApi() }

    // Location services
    single <FusedLocationProviderClient>{ LocationServices.getFusedLocationProviderClient(androidContext()) }
    single { Geocoder(androidContext(), Locale.getDefault()) }

    // data source
    single { WeatherDataSource(get()) }
    single { LocationDataSource(get(), get()) }

    // repository
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
    single<LocationRepository> { LocationRepositoryImpl(get()) }

    // use cases
    single { GetCurrentWeather(get(), get()) }
    single { GetDailyWeather(get(), get()) }
    single { GetTodayHourlyWeather(get(), get()) }
    single { GetWeatherStatus(get(), get()) }
    single { GetTodayHourlyTheme(get(), get()) }
    single { GetLocationUseCase(get()) }

    // view models
    viewModel { WeatherStatusViewModel(get()) }
    viewModel { TodayHourlyWeatherViewModel(get()) }
    viewModel { CurrentWeatherViewModel(get()) }
    viewModel { WeatherNextDaysViewModel(get()) }
    viewModel { TodayHourlyThemeViewModel(get()) }
    viewModel { LocationViewModel(get()) }

}
