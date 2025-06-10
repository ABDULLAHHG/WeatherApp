package com.example.weatherapp.Data.remote.dto

import kotlinx.serialization.Serializable


@Serializable
data class DailyDto(
    val time: List<String>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
    val weather_code: List<Int>,
    val uv_index_max: List<Double>,
    val precipitation_probability_max : List<Double>
)