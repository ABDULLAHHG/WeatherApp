package com.example.weatherapp.data.datasource.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class DailyWeatherForecastDto(
    val time: List<String>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
    val weather_code: List<Int>,
    val uv_index_max: List<Double>,
    val precipitation_probability_max : List<Double>
)