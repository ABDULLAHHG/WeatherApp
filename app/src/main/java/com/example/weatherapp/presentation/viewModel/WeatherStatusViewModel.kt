package com.example.weatherapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.logic.usecase.GetWeatherStatus
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking

class WeatherStatusViewModel(
    private val getWeatherStatus: GetWeatherStatus
) : ViewModel() {
    private val weatherStatus = runBlocking {
        getWeatherStatus.execute("50", "80")
    }
    private val _statusValue = MutableStateFlow(
        weatherStatus.toUiState()
    )
    val statusValue = _statusValue.asStateFlow()
}