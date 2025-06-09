package com.example.weatherapp.Data

import android.Manifest
import androidx.annotation.RequiresPermission
import com.example.weatherapp.Data.local.WeatherDataSource
import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.Current
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.Today
import com.example.weatherapp.logic.entity.WeatherStatus

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource
) : Repository {
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])

    override suspend fun getCurrentWeather(): Current {
        return weatherDataSource.getCurrentWeather()
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getTodayWeather(): Today {
        return weatherDataSource.getTodayWeather()
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])

    override suspend fun getStatusWeather(): WeatherStatus {
        return weatherDataSource.getStatusWeather()
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])

    override suspend fun getDailyWeather(): NextDays {
        return weatherDataSource.getDailyWeather()
    }
}