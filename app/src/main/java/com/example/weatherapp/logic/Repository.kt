package com.example.weatherapp.logic

import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.TodayWeatherStatus
import com.example.weatherapp.logic.entity.TodayHourlyWeather

interface Repository {
    suspend fun getCurrentWeather(): CurrentWeather
    suspend fun getTodayWeather(): TodayHourlyWeather
    suspend fun getStatusWeather(): TodayWeatherStatus
    suspend fun getDailyWeather(): NextDays

}