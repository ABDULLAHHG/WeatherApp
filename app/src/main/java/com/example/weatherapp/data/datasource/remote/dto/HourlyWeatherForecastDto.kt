package com.example.weatherapp.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherForecastDto(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val weather_code: List<Int>,
    val is_day: List<Int>
)