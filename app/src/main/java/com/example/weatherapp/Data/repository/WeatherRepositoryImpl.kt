package com.example.weatherapp.Data.repository

import android.Manifest
import androidx.annotation.RequiresPermission
import com.example.weatherapp.Data.local.WeatherDataSource
import com.example.weatherapp.logic.reposiotry.WeatherRepository
import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.TodayHourlyWeather
import com.example.weatherapp.logic.entity.TodayWeatherStatus

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource
) : WeatherRepository {
    override suspend fun getCurrentWeather(latitude: String, longitude: String): CurrentWeather {
        return weatherDataSource.getCurrentWeather(latitude , longitude).toCurrentWeather()
    }

    override suspend fun getTodayWeather(latitude: String, longitude: String): TodayHourlyWeather {
        return weatherDataSource.getTodayWeather(latitude , longitude).toTodayHourlyWeather()
    }

    override suspend fun getStatusWeather(latitude: String, longitude: String): TodayWeatherStatus {
        return weatherDataSource.getStatusWeather(latitude , longitude).toWeatherStatus()
    }

    override suspend fun getDailyWeather(latitude: String, longitude: String): NextDays {
        return weatherDataSource.getDailyWeather(latitude , longitude).toNextDays()
    }
}