package com.example.weatherapp.logic.entity

data class TodayWeatherStatus(
    val windSpeed: Double,
    val humidity: Int,
    val rainVolume: Double,
    val pressure: Double,
    val uvIndex: Double,
    val feelsLike: Double
)
