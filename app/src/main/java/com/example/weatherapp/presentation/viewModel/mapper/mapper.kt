package com.example.weatherapp.presentation.viewModel.mapper

import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.entity.DailyWeatherForecast
import com.example.weatherapp.logic.entity.HourlyWeatherForecast
import com.example.weatherapp.logic.entity.TodayWeatherStatus
import com.example.weatherapp.presentation.theme.WeatherCodeMapper
import com.example.weatherapp.presentation.viewModel.state.CurrentWeatherUiState
import com.example.weatherapp.presentation.viewModel.state.HourlyWeatherForecastUiState
import com.example.weatherapp.presentation.viewModel.state.DailyWeatherForecastUiStates
import com.example.weatherapp.presentation.viewModel.state.WeatherStatusUiState
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

fun CurrentWeather.toUiState(): CurrentWeatherUiState {
    val description = WeatherCodeMapper.weatherCodeToDescription(weatherCode)
    val image = weatherCode.toString()
    val tempFormatted = "${temperature2m.toInt()}°C"
    val min = "${temperatureRange.first.toInt()}°C"
    val max = "${temperatureRange.second.toInt()}°C"

    return CurrentWeatherUiState(
        image = image,
        weatherDescription = description,
        weatherTemperature = tempFormatted,
        temperatureRange = min to max
    )
}


fun DailyWeatherForecast.toUiState(): DailyWeatherForecastUiStates {
    val daysNames = daysWeather.map { it.date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()) }
    val rangeTemperatures = daysWeather.map {
        "${it.minTemperature.toInt()}°C" to "${it.maxTemperature.toInt()}°C"
    }
    val weatherCode = daysWeather.map { it.weatherCode.toString() }

    return DailyWeatherForecastUiStates(
        daysNames = daysNames,
        rangeTemperatures = rangeTemperatures,
        weatherCode = weatherCode
    )
}


fun HourlyWeatherForecast.toUiState(): HourlyWeatherForecastUiState {
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault())

    val weatherCode = hourlyWeather.map { (it.weatherCode).toString() }
    val temperatures = hourlyWeather.map { "${it.temperature.toInt()}°C" }
    val weatherTime = hourlyWeather.map { it.time.format(timeFormatter) }

    return HourlyWeatherForecastUiState(
        weatherCode = weatherCode,
        temperatures = temperatures,
        weatherTime = weatherTime
    )
}


fun TodayWeatherStatus.toUiState(): WeatherStatusUiState {
    return WeatherStatusUiState(
        windValue = "${windSpeed.toInt()} km/h",
        humidityValue = "$humidity%",
        rainValue = "${"%.1f".format(rainVolume)}%",
        pressureValue = "${pressure.toInt()} hPa",
        uvValue = "%.1f".format(uvIndex),
        feelsLikeValue = "${feelsLike.toInt()}°C"
    )
}

