package com.example.weatherapp.logic

import com.example.weatherapp.logic.entity.Current
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.WeatherStatus
import com.example.weatherapp.logic.entity.Today

interface Repository {
    suspend fun getCurrentWeather(): Current
    suspend fun getTodayWeather(): Today
    suspend fun getStatusWeather(): WeatherStatus
    suspend fun getDailyWeather(): NextDays

}