package com.example.weatherapp.Data.local

import android.Manifest
import androidx.annotation.RequiresPermission
import com.example.weatherapp.Data.remote.LocationDatasource
import com.example.weatherapp.Data.remote.WeatherApi
import com.example.weatherapp.Data.remote.dto.DailyDto
import com.example.weatherapp.Data.remote.dto.HourlyDto
import com.example.weatherapp.Data.remote.dto.WeatherInfoDto

class WeatherDataSource(
    private val weatherApi: WeatherApi,
    private val locationDatasource: LocationDatasource
) {
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getCurrentWeather(): WeatherInfoDto {
        val currentCoordinates = locationDatasource.getCurrentCoordinates()
        val weatherInfo = weatherApi.getWeather(currentCoordinates?.first.toString(), currentCoordinates?.second.toString())


        return weatherInfo

    }
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getTodayWeather(latitude: String, longitude: String): HourlyDto {
        val currentCoordinates = locationDatasource.getCurrentCoordinates()
        val weatherInfo = weatherApi.getWeather(currentCoordinates?.first.toString(), currentCoordinates?.second.toString())
        return weatherInfo.hourly
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getStatusWeather(latitude: String, longitude: String): WeatherInfoDto {
        val currentCoordinates = locationDatasource.getCurrentCoordinates()
        val weatherInfo = weatherApi.getWeather(currentCoordinates?.first.toString(), currentCoordinates?.second.toString())
        return weatherInfo
    }
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getDailyWeather(): DailyDto {
        val currentCoordinates = locationDatasource.getCurrentCoordinates()
        val weatherInfo = weatherApi.getWeather(currentCoordinates?.first.toString(), currentCoordinates?.second.toString())
        return weatherInfo.daily
    }

}