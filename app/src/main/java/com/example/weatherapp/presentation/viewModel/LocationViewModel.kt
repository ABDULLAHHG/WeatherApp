package com.example.weatherapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.logic.usecase.GetLocationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class LocationViewModel(
    private val getLocationUseCase: GetLocationUseCase
) : ViewModel() {


    private val _statusValue = MutableStateFlow(
        "Location"
    )
    val statusValue = _statusValue.asStateFlow()


    init {
        getLocation()
    }

    private fun getLocation() {
        viewModelScope.launch(Dispatchers.IO) {
            getLocationUseCase.execute().let { state ->
                _statusValue.update {
                    state.cityName
                }
            }
        }
    }
}