package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.reposiotry.WeatherRepository
import com.example.weatherapp.logic.entity.DailyWeatherForecast
import com.example.weatherapp.logic.reposiotry.LocationRepository

class GetDailyWeatherForecast(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository

) {
    suspend fun execute(numberOfDays : Int = 7): DailyWeatherForecast {
        val location = locationRepository.getCurrentLocation()

        val nextDays =  weatherRepository.getDailyWeather(
            latitude = location.latitude.toString(),
            longitude = location.longitude.toString()
        )
        return DailyWeatherForecast(
            daysWeather = nextDays.daysWeather.take(numberOfDays)
        )
    }
}