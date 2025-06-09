package com.example.weatherapp.viewModel.state

data class WeatherNextDaysUiStates(
    val daysNames: List<String>,
    val rangeTemperatures: List<Pair<Double , Double>>,
    val weatherType: List<String>,

)