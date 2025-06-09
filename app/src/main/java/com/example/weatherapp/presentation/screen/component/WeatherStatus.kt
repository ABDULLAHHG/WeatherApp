package com.example.weatherapp.presentation.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.screen.composable.StatusCard
import com.example.weatherapp.viewModel.StatusValueViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherStatus(
    viewModel: StatusValueViewModel = koinViewModel()
) {
    val state by viewModel.statusValue.collectAsState()
    WeatherStatusContent(
        windValue = state.windValue,
        humidityValue = state.humidityValue,
        rainValue = state.rainValue,
        pressureValue = state.pressureValue,
        uvValue = state.uvValue,
        feelsLikeValue = state.feelsLikeValue
    )
}

@Composable
fun WeatherStatusContent(
    windValue: String,
    humidityValue: String,
    rainValue: String,
    pressureValue: String,
    uvValue: String,
    feelsLikeValue: String
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            StatusCard(
                image = ImageVector.vectorResource(R.drawable.fast_wind),
                value = windValue,
                statusType = "Wind",
                modifier = Modifier.weight(1f)
            )
            StatusCard(
                image = ImageVector.vectorResource(R.drawable.humidity),
                value = humidityValue,
                statusType = "Humidity",
                modifier = Modifier.weight(1f)
            )
            StatusCard(
                image = ImageVector.vectorResource(R.drawable.rain),
                value = rainValue,
                statusType = "Rain",
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {

            StatusCard(
                image = ImageVector.vectorResource(R.drawable.uv),
                value = uvValue,
                statusType = "UV Index",
                modifier = Modifier.weight(1f)
            )
            StatusCard(
                image = ImageVector.vectorResource(R.drawable.arrow_down),
                value = pressureValue,
                statusType = "Pressure",
                modifier = Modifier.weight(1f)
            )
            StatusCard(
                image = ImageVector.vectorResource(R.drawable.temperature),
                value = feelsLikeValue,
                statusType = "Feels Like",
                modifier = Modifier.weight(1f)
            )
        }

    }
}