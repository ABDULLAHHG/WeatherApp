package com.example.weatherapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.logic.usecase.GetCurrentWeather
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import com.example.weatherapp.presentation.viewModel.state.CurrentWeatherUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CurrentWeatherViewModel(
    private val getCurrentWeather: GetCurrentWeather
) : ViewModel() {


    private val _statusValue = MutableStateFlow(
        CurrentWeatherUiState(
            image = "",
            weatherDescription = "",
            weatherTemperature = "",
            temperatureRange = "" to ""
        )
    )
    val statusValue = _statusValue.asStateFlow()
    init {
        getCurrentWeather()
    }


    private fun getCurrentWeather() {
        viewModelScope.launch (Dispatchers.IO){
            getCurrentWeather.execute().toUiState().let { state ->
                _statusValue.update {
                    state
                }
            }
        }
    }


}