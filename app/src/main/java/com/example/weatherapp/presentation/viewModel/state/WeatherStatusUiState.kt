package com.example.weatherapp.presentation.viewModel.state

data class WeatherStatusUiState(
    val windValue: String,
    val humidityValue: String,
    val rainValue: String,
    val pressureValue: String,
    val uvValue: String,
    val feelsLikeValue: String
)