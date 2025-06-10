package com.example.weatherapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.component.CurrentWeather
import com.example.weatherapp.presentation.component.WeatherNextDays
import com.example.weatherapp.presentation.component.WeatherScaffold
import com.example.weatherapp.presentation.component.WeatherStatus
import com.example.weatherapp.presentation.component.WeatherToday
import com.example.weatherapp.presentation.composable.AppBarContent
import com.example.weatherapp.presentation.theme.WeatherAppTheme
import com.example.weatherapp.presentation.theme.WeatherTheme
import com.example.weatherapp.presentation.theme.urbanistFamily

@Composable
fun MainScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(WeatherTheme.colorScheme.appBackgroundColor)
            .padding(horizontal = 12.dp)
    ) {
        item() {
            WeatherScaffold() {
                AppBarContent("Location")
            }
            CurrentWeather()
            Spacer(modifier = Modifier.height(24.dp))
            WeatherStatus()
            Spacer(modifier = Modifier.height(24.dp))
            WeatherToday()
            Spacer(modifier = Modifier.height(24.dp))
            WeatherNextDays()
            Spacer(modifier = Modifier.height(24.dp))
//        WeatherNextDays()

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