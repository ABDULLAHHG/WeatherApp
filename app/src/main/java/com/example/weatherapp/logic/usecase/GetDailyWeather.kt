package com.example.weatherapp.logic.usecase

import com.example.weatherapp.logic.reposiotry.WeatherRepository
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.reposiotry.LocationRepository

class GetDailyWeather(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository

) {
    suspend fun execute(numberOfDays : Int = 7): NextDays {
        val location = locationRepository.getCurrentLocation()

        val nextDays =  weatherRepository.getDailyWeather(
            latitude = location.latitude.toString(),
            longitude = location.longitude.toString()
        )
        return NextDays(
            daysWeather = nextDays.daysWeather.take(numberOfDays)
        )
    }
}