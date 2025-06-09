package com.example.weatherapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.logic.usecase.GetCurrentWeather
import com.example.weatherapp.presentation.screen.composable.WeatherCodeMapper
import com.example.weatherapp.viewModel.state.CurrentWeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking

class CurrentWeatherViewModel(
    private val getCurrentWeather: GetCurrentWeather
) : ViewModel() {
    private val currentWeather = runBlocking {
        getCurrentWeather.execute("50", "50")
    }
        private val _statusValue = MutableStateFlow(
        CurrentWeatherUiState(
            image = currentWeather.weatherCode.toString(),
            weatherDescription = WeatherCodeMapper.weatherCodeToDescription(currentWeather.weatherCode),
            weatherTemperature = currentWeather.temperature2m.toString(),
            temperatureRange = currentWeather.temperatureRange
        )
    )
    val statusValue = _statusValue.asStateFlow()


}