package com.example.weatherapp.presentation.viewModel.state

data class WeatherNextDaysUiStates(
    val daysNames: List<String>,
    val rangeTemperatures: List<Pair<String, String>>,
    val weatherCode: List<String>,

    )