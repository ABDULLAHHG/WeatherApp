package com.example.weatherapp.viewModel.state

import androidx.compose.ui.graphics.painter.Painter

data class CurrentWeatherUiState(
    val image: String,
    val weatherDescription: String,
    val weatherTemperature: String,
    val temperatureRange: Pair<Int, Int>
)