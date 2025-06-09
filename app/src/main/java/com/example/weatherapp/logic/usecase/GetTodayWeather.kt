package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.Today
import java.time.LocalDateTime

class GetTodayWeather(
    private val repository: Repository

) {
    suspend fun execute(): Today {
        val today =  repository.getTodayWeather()
        val todayTime = LocalDateTime.now()

        return Today(
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