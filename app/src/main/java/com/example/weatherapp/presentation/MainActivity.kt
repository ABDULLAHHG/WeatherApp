package com.example.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.weatherapp.presentation.screen.MainScreen
import com.example.weatherapp.presentation.theme.WeatherAppTheme
import requestLocationPermission

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val hasPermission = requestLocationPermission()

            if (hasPermission.value) {
                WeatherAppTheme {
                    MainScreen()
                }

            }

        }
    }
}