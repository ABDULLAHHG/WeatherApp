package com.example.weatherapp.viewModel
import androidx.lifecycle.ViewModel
import com.example.weatherapp.logic.usecase.GetTodayWeather
import com.example.weatherapp.viewModel.state.WeatherTodayStatusUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking

class TodayValueViewModel(
    private val  getHourlyWeather : GetTodayWeather
) : ViewModel() {
    private val currentWeather = runBlocking {
        getHourlyWeather.execute("50", "50")
    }
    private val _statusValue = MutableStateFlow(
        WeatherTodayStatusUiState(
            weatherType = currentWeather.weatherType.map { it.toString() },
            temperatures = currentWeather.temperatures.map { it.toString() },
            weatherTime = currentWeather.weatherTime,
        )
    )
    val statusValue = _statusValue.asStateFlow()
}