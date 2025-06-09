package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.WeatherStatus

class GetWeatherStatus(
    private val repository: Repository
) {
    suspend fun execute(latitude: String, longitude: String): WeatherStatus {
        return repository.getStatusWeather(latitude, longitude)
    }
}