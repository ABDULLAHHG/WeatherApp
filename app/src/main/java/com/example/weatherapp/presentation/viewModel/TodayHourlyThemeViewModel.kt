package com.example.weatherapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.logic.entity.HourlyWeather
import com.example.weatherapp.logic.usecase.GetTodayHourlyTheme
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime


class TodayHourlyThemeViewModel(
    private val getTodayHourlyTheme: GetTodayHourlyTheme
) : ViewModel() {


    private val _statusValue = MutableStateFlow(
        HourlyWeather(
            time = LocalDateTime.now(),
            temperature = 1.0,
            weatherCode = 1,
            isDay = true
        )
    )
    val statusValue = _statusValue.asStateFlow()


    init {
        getTodayHourlyTheme()
    }
    private fun getTodayHourlyTheme() {
        viewModelScope.launch(Dispatchers.IO) {
            getTodayHourlyTheme.execute().let { state ->
                _statusValue.update {
                    state
                }
            }
        }
    }
}