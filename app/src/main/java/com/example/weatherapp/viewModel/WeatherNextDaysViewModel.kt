package com.example.weatherapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.logic.usecase.GetDailyWeather
import com.example.weatherapp.viewModel.state.WeatherNextDaysUiStates
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
        WeatherNextDaysUiStates(
            daysNames = dailyWeather.daysNames,
            rangeTemperatures = dailyWeather.rangeTemperatures,
            weatherType = dailyWeather.weatherType.map { it.toString() }
        )
    )
    val statusValue = _statusValue.asStateFlow()
}

