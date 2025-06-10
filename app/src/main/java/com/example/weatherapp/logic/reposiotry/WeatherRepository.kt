package com.example.weatherapp.logic.reposiotry

import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.TodayHourlyWeather
import com.example.weatherapp.logic.entity.TodayWeatherStatus

interface WeatherRepository {
    suspend fun getCurrentWeather(latitude: String, longitude: String): CurrentWeather
    suspend fun getTodayWeather(latitude: String, longitude: String): TodayHourlyWeather
    suspend fun getStatusWeather(latitude: String, longitude: String): TodayWeatherStatus
    suspend fun getDailyWeather(latitude: String, longitude: String): NextDays

}