package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.reposiotry.WeatherRepository
import com.example.weatherapp.logic.entity.TodayWeatherStatus
import com.example.weatherapp.logic.reposiotry.LocationRepository

class GetWeatherStatus(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository
) {
    suspend fun execute(): TodayWeatherStatus {
        val location = locationRepository.getCurrentLocation()
        return weatherRepository.getStatusWeather(
            latitude = location.latitude.toString(),
            longitude = location.longitude.toString()
        )
    }
}