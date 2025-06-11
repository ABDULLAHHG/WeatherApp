package com.example.weatherapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.component.AppBar
import com.example.weatherapp.presentation.component.CurrentWeather
import com.example.weatherapp.presentation.component.WeatherNextDays
import com.example.weatherapp.presentation.component.WeatherScaffold
import com.example.weatherapp.presentation.component.WeatherStatus
import com.example.weatherapp.presentation.component.WeatherToday
import com.example.weatherapp.presentation.theme.WeatherAppTheme
import com.example.weatherapp.presentation.theme.WeatherTheme

@Composable
fun MainScreen(
) {
    val lazyListState = rememberLazyListState()
    val rawScroll = remember { derivedStateOf { lazyListState.firstVisibleItemScrollOffset } }

    val maxScrollPx = 120f
    val scrollProgress = (rawScroll.value / maxScrollPx).coerceIn(0f, 1f)
    MainScreenContent(scrollProgress, lazyListState)
}

@Composable
fun MainScreenContent(scrollProgress: Float, scrollState: LazyListState) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(WeatherTheme.colorScheme.appBackgroundColor),
        state = scrollState,

        ) {
        item {
            WeatherScaffold() {
                AppBar()
            }
            CurrentWeather(scrollProgress = scrollProgress)
            Spacer(modifier = Modifier.height(24.dp))
            WeatherStatus()
            Spacer(modifier = Modifier.height(24.dp))
            WeatherToday()
            Spacer(modifier = Modifier.height(24.dp))
            WeatherNextDays()
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppTheme {
        MainScreen()
    }
}