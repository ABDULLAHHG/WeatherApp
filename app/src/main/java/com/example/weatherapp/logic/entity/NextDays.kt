package com.example.weatherapp.logic.entity

data class NextDays (
    val daysNames: List<String>,
    val rangeTemperatures: List<Pair<Double , Double>>,
    val weatherType: List<Int>,
)