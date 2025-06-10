package com.example.weatherapp.logic.entity

data class CurrentWeather(
    val temperature: Double,
    val weatherCode: Int,
    val minTemperature: Double,
    val maxTemperature: Double
)
