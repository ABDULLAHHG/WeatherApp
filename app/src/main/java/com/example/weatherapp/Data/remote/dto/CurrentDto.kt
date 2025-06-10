package com.example.weatherapp.Data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CurrentDto(
    val time: String,
    val interval: Int,
    val temperature_2m: Double,
    val wind_speed_10m: Double,
    val relative_humidity_2m: Int,
    val rain: Double,
    val weather_code: Int,
    val apparent_temperature: Double,
    val pressure_msl: Double,
    val is_day: Int,
    val precipitation: Double
)
