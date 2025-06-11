package com.example.weatherapp.logic.reposiotry

import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.entity.DailyWeatherForecast
import com.example.weatherapp.logic.entity.HourlyWeatherForecast
import com.example.weatherapp.logic.entity.TodayWeatherStatus

interface WeatherRepository {
    suspend fun getCurrentWeather(latitude: String, longitude: String): CurrentWeather
    suspend fun getHourlyWeatherForecast(latitude: String, longitude: String): HourlyWeatherForecast
    suspend fun getStatusWeather(latitude: String, longitude: String): TodayWeatherStatus
    suspend fun getDailyWeather(latitude: String, longitude: String): DailyWeatherForecast

}