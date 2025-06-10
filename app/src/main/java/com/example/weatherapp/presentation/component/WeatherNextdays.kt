package com.example.weatherapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.presentation.composable.NextDaysCard
import com.example.weatherapp.presentation.composable.WeatherCodeMapper
import com.example.weatherapp.presentation.theme.WeatherTheme
import com.example.weatherapp.presentation.theme.urbanistFamily
import com.example.weatherapp.presentation.viewModel.WeatherNextDaysViewModel
import com.example.weatherapp.presentation.viewModel.state.WeatherNextDaysUiStates
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherNextDays(
    viewModel: WeatherNextDaysViewModel = koinViewModel()
) {
    val state by viewModel.statusValue.collectAsState()
    WeatherNextDaysContent(state)
}

@Composable
fun WeatherNextDaysContent(state: WeatherNextDaysUiStates) {
    Text(
        "Next 7 Days", modifier = Modifier.padding(bottom = 12.dp),
        fontSize = 20.sp,
        fontFamily = urbanistFamily,
        color = WeatherTheme.colorScheme.nextDaysLabelFontColor,
        letterSpacing = 0.25.sp,
        fontWeight = FontWeight(600)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .border(
                1.dp,
                WeatherTheme.colorScheme.nextDaysCardBorderColor,
                shape = RoundedCornerShape(24.dp)
            )
            .background(WeatherTheme.colorScheme.nextDaysCardBackgroundColor)
    ) {
        state.daysNames.forEachIndexed { index, dayName ->
            NextDaysCard(
                dayName = dayName,
                temperatureRange = state.rangeTemperatures[index],
                image = painterResource(WeatherCodeMapper.weatherCodeToIconLightTheme(state.weatherCode[index]))
            )
            if (index != state.daysNames.size - 1) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = WeatherTheme.colorScheme.nextDaysCardBorderColor
                )
            }
        }


    }
}