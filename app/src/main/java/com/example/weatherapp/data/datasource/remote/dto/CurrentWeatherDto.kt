package com.example.weatherapp.data.datasource.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDto(
    @SerialName("time") val time: String,
    @SerialName("interval") val interval: Int,
    @SerialName("temperature_2m") val temperature2m: Double,
    @SerialName("wind_speed_10m") val windSpeed10m: Double,
    @SerialName("relative_humidity_2m") val relativeHumidity2m: Int,
    @SerialName("rain") val rain: Double,
    @SerialName("weather_code") val weatherCode: Int,
    @SerialName("apparent_temperature") val apparentTemperature: Double,
    @SerialName("pressure_msl") val pressureMsl: Double,
    @SerialName("is_day") val isDay: Int,
    @SerialName("precipitation") val precipitation: Double
)