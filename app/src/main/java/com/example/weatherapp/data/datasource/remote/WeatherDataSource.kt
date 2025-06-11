package com.example.weatherapp.data.datasource.remote

import com.example.weatherapp.data.datasource.remote.api.WeatherApi
import com.example.weatherapp.data.datasource.remote.dto.DailyWeatherForecastDto
import com.example.weatherapp.data.datasource.remote.dto.HourlyWeatherForecastDto
import com.example.weatherapp.data.datasource.remote.dto.WeatherInfoDto

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

    suspend fun getTodayWeather(latitude: String, longitude: String): HourlyWeatherForecastDto {
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

    suspend fun getDailyWeather(latitude: String, longitude: String): DailyWeatherForecastDto {
        val weatherInfo = weatherApi.getWeather(
            latitude = latitude,
            longitude = longitude
        )
        return weatherInfo.daily
    }

}