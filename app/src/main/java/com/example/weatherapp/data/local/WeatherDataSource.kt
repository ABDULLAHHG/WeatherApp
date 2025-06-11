package com.example.weatherapp.data.local

import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.data.remote.dto.DailyDto
import com.example.weatherapp.data.remote.dto.HourlyDto
import com.example.weatherapp.data.remote.dto.WeatherInfoDto

class WeatherDataSource(
    private val weatherApi: WeatherApi,
) {
    suspend fun getCurrentWeather(latitude: String, longitude: String): WeatherInfoDto {
        val weatherInfo = weatherApi.getWeather(
            latitude = latitude,
            longitude = longitude
        )
        return weatherInfo

    }

    suspend fun getTodayWeather(latitude: String, longitude: String): HourlyDto {
        val weatherInfo = weatherApi.getWeather(
            latitude = latitude,
            longitude = longitude
        )
        return weatherInfo.hourly
    }

    suspend fun getStatusWeather(latitude: String, longitude: String): WeatherInfoDto {
        val weatherInfo = weatherApi.getWeather(
            latitude = latitude,
            longitude = longitude
        )
        return weatherInfo
    }

    suspend fun getDailyWeather(latitude: String, longitude: String): DailyDto {
        val weatherInfo = weatherApi.getWeather(
            latitude = latitude,
            longitude = longitude
        )
        return weatherInfo.daily
    }

}