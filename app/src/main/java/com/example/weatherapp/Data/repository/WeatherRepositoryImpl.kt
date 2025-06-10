package com.example.weatherapp.Data.repository

import android.Manifest
import androidx.annotation.RequiresPermission
import com.example.weatherapp.Data.local.WeatherDataSource
import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.TodayHourlyWeather
import com.example.weatherapp.logic.entity.TodayWeatherStatus

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource
) : Repository {
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getCurrentWeather(): CurrentWeather {
        return weatherDataSource.getCurrentWeather().toCurrentWeather()
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getTodayWeather(): TodayHourlyWeather {
        return weatherDataSource.getTodayWeather().toTodayHourlyWeather()
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getStatusWeather(): TodayWeatherStatus {
        return weatherDataSource.getStatusWeather().toWeatherStatus()
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getDailyWeather(): NextDays {
        return weatherDataSource.getDailyWeather().toNextDays()
    }
}