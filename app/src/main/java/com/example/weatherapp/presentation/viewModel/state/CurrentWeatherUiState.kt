package com.example.weatherapp.presentation.viewModel.state

data class CurrentWeatherUiState(
    val image: String,
    val weatherDescription: String,
    val weatherTemperature: String,
    val temperatureRange: Pair<String, String>
)


