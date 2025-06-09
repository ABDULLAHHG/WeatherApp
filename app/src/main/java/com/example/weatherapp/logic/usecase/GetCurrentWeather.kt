package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.Current

class GetCurrentWeather(
    private val repository: Repository

) {
    suspend fun execute(): Current {
        return repository.getCurrentWeather()
    }
}