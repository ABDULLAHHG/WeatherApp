package com.example.weatherapp.logic.entity

data class Current(
    val temperature2m: Double,
    val weatherCode: Int,
    val isDay: Int,
    val temperatureRange : Pair<Int , Int>
)