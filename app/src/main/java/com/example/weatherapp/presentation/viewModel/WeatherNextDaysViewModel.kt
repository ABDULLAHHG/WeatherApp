package com.example.weatherapp.presentation.viewModel

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.logic.usecase.GetDailyWeather
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import com.example.weatherapp.presentation.viewModel.state.WeatherNextDaysUiStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class WeatherNextDaysViewModel(
    private val getDailyWeather: GetDailyWeather
) : ViewModel() {


    private val _statusValue = MutableStateFlow(
        WeatherNextDaysUiStates(
            daysNames = listOf("1"),
            rangeTemperatures = listOf("1" to "1"),
            weatherCode = listOf("1")
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

