package com.example.weatherapp.presentation.viewModel.state

data class HourlyWeatherForecastUiState(
    val weatherCode: List<String>,
    val temperatures: List<String>,
    val weatherTime: List<String>,
)