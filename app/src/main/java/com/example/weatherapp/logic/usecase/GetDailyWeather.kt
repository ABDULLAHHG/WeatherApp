package com.example.weatherapp.logic.usecase

import com.example.weatherapp.Data.remote.WeatherApi
import com.example.weatherapp.logic.Repository
import com.example.weatherapp.logic.entity.NextDays

class GetDailyWeather(
    private val repository: Repository

) {
    suspend fun execute(numberOfDays : Int = 7): NextDays {
        val nextDays =  repository.getDailyWeather()
        return NextDays(
            nextDays.daysNames.take(numberOfDays),
            nextDays.rangeTemperatures.take(numberOfDays),
            nextDays.weatherType.take(numberOfDays)
        )
    }
}