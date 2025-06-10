package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.reposiotry.WeatherRepository
import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.reposiotry.LocationRepository

class GetCurrentWeather(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository

) {
    suspend fun execute(): CurrentWeather {
        val location = locationRepository.getCurrentLocation()
        return weatherRepository.getCurrentWeather(
            latitude = location.latitude.toString(),
            longitude = location.longitude.toString()
        )
    }
}