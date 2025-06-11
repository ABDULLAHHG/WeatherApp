package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.reposiotry.WeatherRepository
import com.example.weatherapp.logic.entity.HourlyWeatherForecast
import com.example.weatherapp.logic.reposiotry.LocationRepository
import java.time.LocalDateTime

class GetTodayHourlyTheme(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository

) {
    suspend fun execute(): Boolean {
        val location = locationRepository.getCurrentLocation()

        val today =  weatherRepository.getTodayWeather(
            latitude = location.latitude.toString(),
            longitude = location.longitude.toString()
        )
        val todayTime = LocalDateTime.now()

        return HourlyWeatherForecast(
            today.hourlyWeather.take(25).filter {
                (it.time.hour == todayTime.hour)
            }
        ).hourlyWeather[0].isDay
    }
}