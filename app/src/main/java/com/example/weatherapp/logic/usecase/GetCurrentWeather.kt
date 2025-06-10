package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.CurrentWeather

class GetCurrentWeather(
    private val repository: Repository

) {
    suspend fun execute(latitude: String, longitude: String): CurrentWeather {
        return repository.getCurrentWeather(latitude, longitude)
    }
}