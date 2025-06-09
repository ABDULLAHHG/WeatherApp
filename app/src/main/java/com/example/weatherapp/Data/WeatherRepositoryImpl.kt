package com.example.weatherapp.Data

import com.example.weatherapp.Data.local.WeatherDataSource
import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.Current
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.WeatherStatus
import com.example.weatherapp.logic.entity.Today

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource
) : Repository {
    override suspend fun getCurrentWeather(latitude: String, longitude: String): Current {
        return weatherDataSource.getCurrentWeather(latitude, longitude)
    }
    override suspend fun getTodayWeather(latitude: String, longitude: String): Today {
        return weatherDataSource.getTodayWeather(latitude, longitude)
    }
    override suspend fun getStatusWeather(latitude: String, longitude: String): WeatherStatus {
        return weatherDataSource.getStatusWeather(latitude, longitude)
    }
    override suspend fun getDailyWeather(latitude: String, longitude: String): NextDays {
        return weatherDataSource.getDailyWeather(latitude, longitude)
    }
}