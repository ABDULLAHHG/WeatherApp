package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.TodayHourlyWeather
import java.time.LocalDateTime

class GetTodayHourlyWeather(
    private val repository: Repository

) {
    suspend fun execute(latitude: String, longitude: String): TodayHourlyWeather {
        val today =  repository.getTodayWeather(latitude, longitude)
        val todayTime = LocalDateTime.now()

        return TodayHourlyWeather(
            today.hourlyWeather.take(24).filter {
                (it.time.hour > todayTime.hour)
            }
        )
    }
}