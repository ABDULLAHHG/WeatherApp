package com.example.weatherapp.presentation.viewModel.state

data class TodayHourlyWeatherUiState(
    val weatherCode: List<String>,
    val temperatures: List<String>,
    val weatherTime: List<String>,
)