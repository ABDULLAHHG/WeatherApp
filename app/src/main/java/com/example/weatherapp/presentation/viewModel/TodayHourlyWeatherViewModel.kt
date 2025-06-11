package com.example.weatherapp.presentation.viewModel
import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.logic.usecase.GetTodayHourlyWeather
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import com.example.weatherapp.presentation.viewModel.state.TodayHourlyWeatherUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TodayHourlyWeatherViewModel(
    private val  getHourlyWeather : GetTodayHourlyWeather
) : ViewModel() {

    private val _statusValue = MutableStateFlow(
        TodayHourlyWeatherUiState(
            weatherCode = listOf("0"),
            temperatures = listOf("0"),
            weatherTime = listOf("0")
        )
    )
    val statusValue = _statusValue.asStateFlow()

    init {
        getHourlyWeather()
    }


    private fun getHourlyWeather() {
        viewModelScope.launch (Dispatchers.IO){
            getHourlyWeather.execute().toUiState().let { state ->
                _statusValue.update {
                    state
                }
            }
        }
    }
}