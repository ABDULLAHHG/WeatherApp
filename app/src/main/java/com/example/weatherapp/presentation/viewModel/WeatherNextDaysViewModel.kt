package com.example.weatherapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.logic.usecase.GetDailyWeather
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking

class WeatherNextDaysViewModel(
    private val getDailyWeather: GetDailyWeather
) : ViewModel() {
    private val dailyWeather = runBlocking {
        getDailyWeather.execute("50", "50")
    }
    private val _statusValue = MutableStateFlow(
        dailyWeather.toUiState()
    )
    val statusValue = _statusValue.asStateFlow()
}

