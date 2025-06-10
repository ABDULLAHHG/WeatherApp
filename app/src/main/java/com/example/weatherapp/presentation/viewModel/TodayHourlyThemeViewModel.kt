package com.example.weatherapp.presentation.viewModel

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import com.example.weatherapp.logic.usecase.GetTodayHourlyTheme
import com.example.weatherapp.logic.usecase.GetTodayHourlyWeather
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking


class TodayHourlyThemeViewModel(
    private val  getTodayHourlyTheme : GetTodayHourlyTheme
) : ViewModel() {

    private val hourlyWeather = runBlocking {
        getTodayHourlyTheme.execute()
    }
    private val _statusValue = MutableStateFlow(
        hourlyWeather
    )
    val statusValue = _statusValue.asStateFlow()
}