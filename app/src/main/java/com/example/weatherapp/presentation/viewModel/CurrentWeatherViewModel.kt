package com.example.weatherapp.presentation.viewModel

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.ViewModel
import com.example.weatherapp.logic.usecase.GetCurrentWeather
import com.example.weatherapp.presentation.viewModel.mapper.toUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking

class CurrentWeatherViewModel(
    private val getCurrentWeather: GetCurrentWeather
) : ViewModel() {

    private val currentWeather = runBlocking {
        getCurrentWeather.execute()
    }
        private val _statusValue = MutableStateFlow(
            currentWeather.toUiState()
    )
    val statusValue = _statusValue.asStateFlow()


}