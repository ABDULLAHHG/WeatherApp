package com.example.weatherapp.Data.repository

import com.example.weatherapp.Data.remote.dto.DailyDto
import com.example.weatherapp.Data.remote.dto.HourlyDto
import com.example.weatherapp.Data.remote.dto.WeatherInfoDto
import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.entity.DailyWeather
import com.example.weatherapp.logic.entity.HourlyWeather
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.TodayHourlyWeather
import com.example.weatherapp.logic.entity.TodayWeatherStatus
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun DailyDto.toNextDays(): NextDays {
    val formatter = DateTimeFormatter.ISO_DATE

    val dailyWeatherList = time.indices.map { index ->
        DailyWeather(
            date = LocalDate.parse(time[index], formatter),
            minTemperature = temperature_2m_min[index],
            maxTemperature = temperature_2m_max[index],
            weatherCode = weather_code[index]
        )
    }

    return NextDays(daysWeather = dailyWeatherList)
}

fun HourlyDto.toTodayHourlyWeather(): TodayHourlyWeather {
    val formatter = DateTimeFormatter.ISO_DATE_TIME // e.g., "2025-06-09T09:00"

    val hourlyWeatherList = time.indices.map { index ->
        HourlyWeather(
            time = LocalDateTime.parse(time[index], formatter),
            temperature = temperature_2m[index],
            weatherCode = weather_code[index],
            isDay = is_day[index] == 1
        )
    }

    return TodayHourlyWeather(hourlyWeather = hourlyWeatherList)

}

fun WeatherInfoDto.toWeatherStatus(): TodayWeatherStatus {
    return TodayWeatherStatus(
        windSpeed = current.wind_speed_10m,
        humidity = current.relative_humidity_2m,
        rainVolume = current.rain,
        pressure = current.pressure_msl,
        uvIndex = daily.uv_index_max.firstOrNull() ?: 0.0,
        feelsLike = current.apparent_temperature
    )
}

fun WeatherInfoDto.toCurrentWeather(): CurrentWeather {
    val minTemp = daily.temperature_2m_min.first()
    val maxTemp = daily.temperature_2m_max.first()

    return CurrentWeather(
        temperature2m = current.temperature_2m,
        weatherCode = current.weather_code,
        isDay = current.is_day,
        temperatureRange = minTemp to maxTemp
    )
}
