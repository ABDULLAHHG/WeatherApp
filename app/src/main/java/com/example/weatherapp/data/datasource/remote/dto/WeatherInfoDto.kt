package com.example.weatherapp.data.datasource.remote.dto


import kotlinx.serialization.Serializable

@Serializable
data class WeatherInfoDto(
    val current: CurrentWeatherDto,
    val hourly: HourlyWeatherForecastDto,
    val daily: DailyWeatherForecastDto
)