package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.reposiotry.WeatherRepository
import com.example.weatherapp.logic.entity.TodayHourlyWeather
import com.example.weatherapp.logic.reposiotry.LocationRepository
import java.time.LocalDateTime

class GetTodayHourlyWeather(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository

) {
    suspend fun execute(): TodayHourlyWeather {
        val location = locationRepository.getCurrentLocation()
        val today =  weatherRepository.getTodayWeather(
            latitude = location.latitude.toString(),
            longitude = location.longitude.toString()
        )
        val todayTime = LocalDateTime.now()

        return TodayHourlyWeather(
            today.hourlyWeather.take(24).filter {
                (it.time.hour > todayTime.hour)
            }
        )
    }
}