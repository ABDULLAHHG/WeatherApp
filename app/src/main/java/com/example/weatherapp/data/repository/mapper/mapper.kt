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
            minTemperature = temperature2mMin[index],
            maxTemperature = temperature2mMax[index],
            weatherCode = weatherCode[index]
        )
    }

    return DailyWeatherForecast(daysWeather = dailyWeatherList)
}

fun HourlyWeatherForecastDto.toHourlyWeatherForecast(): HourlyWeatherForecast {
    val formatter = DateTimeFormatter.ISO_DATE_TIME

    val hourlyWeatherList = time.indices.map { index ->
        HourlyWeather(
            time = LocalDateTime.parse(time[index], formatter),
            temperature = temperature2m[index],
            weatherCode = weatherCode[index],
            isDay = isDay[index] == 1
        )
    }

    return HourlyWeatherForecast(hourlyWeather = hourlyWeatherList)

}

fun WeatherInfoDto.toWeatherStatus(): TodayWeatherStatus {
    return TodayWeatherStatus(
        windSpeed = current.windSpeed10m,
        humidity = current.relativeHumidity2m,
        rainVolume = daily.precipitationProbabilityMax.firstOrNull() ?: 0.0,
        pressure = current.pressureMsl,
        uvIndex = daily.uvIndexMax.firstOrNull() ?: 0.0,
        feelsLike = current.apparentTemperature
    )
}

fun WeatherInfoDto.toCurrentWeather(): CurrentWeather {
    val minTemp = daily.temperature2mMin.first()
    val maxTemp = daily.temperature2mMax.first()

    return CurrentWeather(
        temperature2m = current.temperature2m,
        weatherCode = current.weatherCode,
        isDay = current.isDay == 1,
        temperatureRange = minTemp to maxTemp
    )
}