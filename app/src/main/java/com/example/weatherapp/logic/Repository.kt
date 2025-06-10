package com.example.weatherapp.logic

import com.example.weatherapp.logic.entity.Current
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.WeatherStatus
import com.example.weatherapp.logic.entity.TodayHourlyWeather

interface Repository {
    suspend fun getCurrentWeather(latitude: String, longitude: String): Current
    suspend fun getTodayWeather(latitude: String, longitude: String): TodayHourlyWeather
    suspend fun getStatusWeather(latitude: String, longitude: String): WeatherStatus
    suspend fun getDailyWeather(latitude: String, longitude: String): NextDays

}