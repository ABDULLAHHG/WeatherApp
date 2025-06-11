package com.example.weatherapp.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class WeatherInfoDto(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val utc_offset_seconds: Int,
    val timezone: String,
    val timezone_abbreviation: String,
    val elevation: Double,
    val current: CurrentWeatherDto,
    val hourly: HourlyWeatherForecastDto,
    val daily: DailyWeatherForecastDto
)