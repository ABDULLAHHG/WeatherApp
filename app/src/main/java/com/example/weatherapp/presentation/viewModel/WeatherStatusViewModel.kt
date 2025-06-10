package com.example.weatherapp.presentation.viewModel

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.logic.usecase.GetWeatherStatus
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import com.example.weatherapp.presentation.viewModel.state.WeatherStatusUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class WeatherStatusViewModel(
    private val getWeatherStatus: GetWeatherStatus
) : ViewModel() {
    private val _statusValue = MutableStateFlow(
        WeatherStatusUiState(
            windValue = "1",
            humidityValue = "1",
            rainValue = "1",
            pressureValue = "1",
            uvValue = "1",
            feelsLikeValue = "1"
        )
    )
    val statusValue = _statusValue.asStateFlow()

    init {
        getWeatherStatus()
    }


    private fun getWeatherStatus() {
        viewModelScope.launch (Dispatchers.IO){
            getWeatherStatus.execute().toUiState().let { state ->
                _statusValue.update {
                    state
                }
            }
        }
    }
}
