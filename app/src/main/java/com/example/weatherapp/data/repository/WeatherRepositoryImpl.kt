package com.example.weatherapp.data.repository

import com.example.weatherapp.data.local.WeatherDataSource
import com.example.weatherapp.logic.reposiotry.WeatherRepository
import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.HourlyWeatherForecast
import com.example.weatherapp.logic.entity.TodayWeatherStatus

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource
) : WeatherRepository {
    override suspend fun getCurrentWeather(latitude: String, longitude: String): CurrentWeather {
        return weatherDataSource.getCurrentWeather(latitude , longitude).toCurrentWeather()
    }

    override suspend fun getTodayWeather(latitude: String, longitude: String): HourlyWeatherForecast {
        return weatherDataSource.getTodayWeather(latitude , longitude).toHourlyWeatherForecast()
    }

    override suspend fun getStatusWeather(latitude: String, longitude: String): TodayWeatherStatus {
        return weatherDataSource.getStatusWeather(latitude , longitude).toWeatherStatus()
    }

    override suspend fun getDailyWeather(latitude: String, longitude: String): NextDays {
        return weatherDataSource.getDailyWeather(latitude , longitude).toNextDays()
    }
}