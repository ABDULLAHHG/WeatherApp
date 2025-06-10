package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.HourlyWeather
import com.example.weatherapp.logic.entity.TodayHourlyWeather
import java.time.LocalDateTime

class GetTodayHourlyTheme(
    private val repository: Repository

) {
    suspend fun execute(latitude: String, longitude: String): HourlyWeather {
        val today =  repository.getTodayWeather(latitude, longitude)
        val todayTime = LocalDateTime.now()

        return TodayHourlyWeather(
            today.hourlyWeather.take(25).filter {
                (it.time.hour == todayTime.hour)
            }
        ).hourlyWeather[0]
    }
}