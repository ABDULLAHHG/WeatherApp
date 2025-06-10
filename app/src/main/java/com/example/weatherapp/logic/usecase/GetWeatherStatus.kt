package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.TodayWeatherStatus

class GetWeatherStatus(
    private val repository: Repository
) {
    suspend fun execute(): TodayWeatherStatus {
        return repository.getStatusWeather()
    }
}