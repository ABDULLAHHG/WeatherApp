package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.TodayHourlyWeather
import java.time.LocalDateTime

class GetTodayWeather(
    private val repository: Repository

) {
    suspend fun execute(latitude: String, longitude: String): TodayHourlyWeather {
        val today =  repository.getTodayWeather(latitude, longitude)
        val todayTime = LocalDateTime.now()

        return TodayHourlyWeather(
            today.weatherType.take(24),
            today.temperatures.take(24),
            today.weatherTime.take(24).filter {
                (LocalDateTime.parse(it).hour > todayTime.hour)
            }.map{
                LocalDateTime.parse(it).hour.toString()
            },
        )
    }
}