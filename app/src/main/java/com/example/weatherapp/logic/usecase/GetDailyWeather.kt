package com.example.weatherapp.logic.usecase

import com.example.weatherapp.Data.remote.WeatherApi
import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.NextDays

class GetDailyWeather(
    private val repository: Repository

) {
    suspend fun execute(latitude: String, longitude: String , numberOfDays : Int = 7): NextDays {
        val nextDays =  repository.getDailyWeather(latitude, longitude)
        return NextDays(
            daysWeather = nextDays.daysWeather.take(numberOfDays)
        )
    }
}