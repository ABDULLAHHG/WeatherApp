package com.example.weatherapp.logic.entity

import java.time.LocalDate

data class DailyWeather(
    val date: LocalDate,
    val minTemperature: Double,
    val maxTemperature: Double,
    val weatherCode: Int
)
