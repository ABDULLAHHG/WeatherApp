package com.example.weatherapp.presentation.viewModel
import androidx.lifecycle.ViewModel
import com.example.weatherapp.logic.usecase.GetTodayHourlyWeather
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking

class TodayHourlyWeatherViewModel(
    private val  getHourlyWeather : GetTodayHourlyWeather
) : ViewModel() {
    private val hourlyWeather = runBlocking {
        getHourlyWeather.execute("50", "50")
    }
    private val _statusValue = MutableStateFlow(
        hourlyWeather.toUiState()
    )
    val statusValue = _statusValue.asStateFlow()
}