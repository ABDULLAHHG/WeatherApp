package com.example.weatherapp.logic.entity

data class Today (
    val weatherType: List<Int>,
    val temperatures: List<Double>,
    val weatherTime: List<String>
)