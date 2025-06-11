package com.example.weatherapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.logic.usecase.GetDailyWeatherForecast
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import com.example.weatherapp.presentation.viewModel.state.DailyWeatherForecastUiStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DailyWeatherForecastViewModel(
    private val getDailyWeather: GetDailyWeatherForecast
) : ViewModel() {


    private val _statusValue = MutableStateFlow(
        DailyWeatherForecastUiStates(
            daysNames = listOf("0"),
            rangeTemperatures = listOf("0" to "0"),
            weatherCode = listOf("0")
        )
    )
    val statusValue = _statusValue.asStateFlow()

    init {
        getDailyWeather()
    }


    private fun getDailyWeather() {
        viewModelScope.launch (Dispatchers.IO){
            getDailyWeather.execute().toUiState().let { state ->
                _statusValue.update {
                    state
                }
            }
        }
    }
}

