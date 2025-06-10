package com.example.weatherapp.logic

import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.TodayWeatherStatus
import com.example.weatherapp.logic.entity.TodayHourlyWeather

interface Repository {
    suspend fun getCurrentWeather(latitude: String, longitude: String): CurrentWeather
    suspend fun getTodayWeather(latitude: String, longitude: String): TodayHourlyWeather
    suspend fun getStatusWeather(latitude: String, longitude: String): TodayWeatherStatus
    suspend fun getDailyWeather(latitude: String, longitude: String): NextDays

}