package com.example.weatherapp.presentation.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.logic.usecase.GetHourlyWeatherForecast
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import com.example.weatherapp.presentation.viewModel.state.HourlyWeatherForecastUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HourlyWeatherForecastViewModel(
    private val  getHourlyWeather : GetHourlyWeatherForecast
) : ViewModel() {

    private val _statusValue = MutableStateFlow(
        HourlyWeatherForecastUiState(
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