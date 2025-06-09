package com.example.weatherapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.logic.usecase.GetCurrentWeather
import com.example.weatherapp.logic.usecase.GetWeatherStatus
import com.example.weatherapp.viewModel.state.WeatherStatusUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking

class StatusValueViewModel(
    private val  getWeatherStatus : GetWeatherStatus
) : ViewModel() {
    private val currentWeather = runBlocking {
        getWeatherStatus.execute()
    }
    private val _statusValue = MutableStateFlow(
        WeatherStatusUiState(
            windValue = currentWeather.windValue,
            humidityValue = currentWeather.humidityValue,
            rainValue = currentWeather.rainValue,
            pressureValue = currentWeather.pressureValue,
            uvValue = currentWeather.uvValue,
            feelsLikeValue = currentWeather.feelsLikeValue
        )
    )
    val statusValue = _statusValue.asStateFlow()
}