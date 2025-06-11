package com.example.weatherapp.data.datasource.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherForecastDto(
    @SerialName("time") val time: List<String>,
    @SerialName("temperature_2m_max") val temperature2mMax: List<Double>,
    @SerialName("temperature_2m_min") val temperature2mMin: List<Double>,
    @SerialName("weather_code") val weatherCode: List<Int>,
    @SerialName("uv_index_max") val uvIndexMax: List<Double>,
    @SerialName("precipitation_probability_max") val precipitationProbabilityMax: List<Double>
)