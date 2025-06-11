package com.example.weatherapp.data.repository.mapper

import com.example.weatherapp.data.datasource.remote.dto.DailyWeatherForecastDto
import com.example.weatherapp.data.datasource.remote.dto.HourlyWeatherForecastDto
import com.example.weatherapp.data.datasource.remote.dto.WeatherInfoDto
import com.example.weatherapp.logic.entity.CurrentWeather
import com.example.weatherapp.logic.entity.DailyWeather
import com.example.weatherapp.logic.entity.HourlyWeather
import com.example.weatherapp.logic.entity.DailyWeatherForecast
import com.example.weatherapp.logic.entity.HourlyWeatherForecast
import com.example.weatherapp.logic.entity.TodayWeatherStatus
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun DailyWeatherForecastDto.toDailyWeatherForecast(): DailyWeatherForecast {
    val formatter = DateTimeFormatter.ISO_DATE

    val dailyWeatherList = time.indices.map { index ->
        DailyWeather(
            date = LocalDate.parse(time[index], formatter),
            minTemperature = temperature_2m_min[index],
            maxTemperature = temperature_2m_max[index],
            weatherCode = weather_code[index]
        )
    }

    return DailyWeatherForecast(daysWeather = dailyWeatherList)
}

fun HourlyWeatherForecastDto.toHourlyWeatherForecast(): HourlyWeatherForecast {
    val formatter = DateTimeFormatter.ISO_DATE_TIME

    val hourlyWeatherList = time.indices.map { index ->
        HourlyWeather(
            time = LocalDateTime.parse(time[index], formatter),
            temperature = temperature_2m[index],
            weatherCode = weather_code[index],
            isDay = is_day[index] == 1
        )
    }

    return HourlyWeatherForecast(hourlyWeather = hourlyWeatherList)

}

fun WeatherInfoDto.toWeatherStatus(): TodayWeatherStatus {
    return TodayWeatherStatus(
        windSpeed = current.wind_speed_10m,
        humidity = current.relative_humidity_2m,
        rainVolume = daily.precipitation_probability_max.firstOrNull() ?: 0.0,
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
