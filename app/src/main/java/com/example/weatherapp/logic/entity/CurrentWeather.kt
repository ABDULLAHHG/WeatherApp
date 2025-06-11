package com.example.weatherapp.logic.entity

data class CurrentWeather(
    val temperature2m: Double,
    val weatherCode: Int,
    val isDay: Boolean,
    val temperatureRange : Pair<Double , Double>
)