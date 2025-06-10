package com.example.weatherapp.logic.entity

import java.time.LocalDateTime

data class TodayHourlyWeather (
    val hourlyWeather: List<HourlyWeather>,
)