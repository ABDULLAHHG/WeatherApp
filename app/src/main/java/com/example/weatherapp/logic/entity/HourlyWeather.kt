package com.example.weatherapp.logic.entity

import java.time.LocalDateTime

data class HourlyWeather(
    val time: LocalDateTime,
    val temperature: Double,
    val weatherCode: Int,
    val isDay: Boolean
)
