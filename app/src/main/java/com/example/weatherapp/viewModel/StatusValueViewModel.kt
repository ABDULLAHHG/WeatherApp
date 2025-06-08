package com.example.weatherapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.viewModel.state.WeatherStatusUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StatusValueViewModel : ViewModel() {
    private val _statusValue = MutableStateFlow(
        WeatherStatusUiState(
            windValue = "13 KM/h",
            humidityValue = "24%",
            rainValue = "2%",
            pressureValue = "2",
            uvValue = "1012 hPa",
            feelsLikeValue = "22°C"
        )
    )
    val statusValue = _statusValue.asStateFlow()
}