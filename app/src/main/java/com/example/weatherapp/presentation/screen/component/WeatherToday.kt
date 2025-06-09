package com.example.weatherapp.presentation.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.presentation.screen.composable.TodayCard
import com.example.weatherapp.presentation.screen.composable.WeatherCodeMapper
import com.example.weatherapp.presentation.screen.theme.WeatherTheme
import com.example.weatherapp.presentation.screen.theme.urbanistFamily
import com.example.weatherapp.viewModel.TodayValueViewModel
import com.example.weatherapp.viewModel.state.WeatherTodayStatusUiState
import org.koin.androidx.compose.koinViewModel


@Composable
fun WeatherToday(
    viewModel: TodayValueViewModel = koinViewModel()
) {
    val state by viewModel.statusValue.collectAsState()
    WeatherTodayContent(state)
}


@Composable
fun WeatherTodayContent(state: WeatherTodayStatusUiState) {
    Text(
        "Today",
        fontSize = 20.sp,
        color = WeatherTheme.colorScheme.todayLabelFontColor,
        letterSpacing = 0.25.sp,
        fontFamily = urbanistFamily,
        fontWeight = FontWeight(600),
        modifier = Modifier.padding(bottom = 24.dp)
    )
    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(state.weatherTime.size) { index ->
            TodayCard(
                image = painterResource(id = WeatherCodeMapper.weatherCodeToIcon(state.weatherType[index])),
                temperature = state.temperatures[index],
                time = state.weatherTime[index]
            )
        }
    }
}

