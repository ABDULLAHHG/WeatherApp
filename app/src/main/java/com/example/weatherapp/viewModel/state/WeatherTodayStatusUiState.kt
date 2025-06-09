package com.example.weatherapp.viewModel.state

data class WeatherTodayStatusUiState(
    val weatherType: List<String>,
    val temperatures: List<String>,
    val weatherTime: List<String>,
)