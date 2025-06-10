package com.example.weatherapp.Data.local

import com.example.weatherapp.Data.remote.WeatherApi
import com.example.weatherapp.Data.remote.dto.DailyDto
import com.example.weatherapp.Data.remote.dto.HourlyDto
import com.example.weatherapp.Data.remote.dto.WeatherInfoDto

class WeatherDataSource(
    private val weatherApi: WeatherApi,
) {
    suspend fun getCurrentWeather(latitude: String, longitude: String): WeatherInfoDto {
        val weatherResponse = weatherApi.getWeather(latitude, longitude)
        return weatherResponse

    }

    suspend fun getTodayWeather(latitude: String, longitude: String): HourlyDto {
        val weatherResponse = weatherApi.getWeather(latitude, longitude)
        return weatherResponse.hourly
    }

    suspend fun getStatusWeather(latitude: String, longitude: String): WeatherInfoDto {
        val weatherResponse = weatherApi.getWeather(latitude, longitude)
        return weatherResponse

    }

    suspend fun getDailyWeather(latitude: String, longitude: String): DailyDto {
        val weatherResponse = weatherApi.getWeather(latitude, longitude)
        return weatherResponse.daily


    }

}