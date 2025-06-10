package com.example.weatherapp.logic.entity

data class WeatherStatus(
    val windSpeed: Double,      // km/h
    val humidity: Int,          // %
    val rainVolume: Double,     // mm
    val pressure: Double,       // hPa
    val uvIndex: Double,
    val feelsLike: Double
)
