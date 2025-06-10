package com.example.weatherapp.Data.local

import com.example.weatherapp.Data.remote.WeatherApi
import com.example.weatherapp.logic.entity.Current
import com.example.weatherapp.logic.entity.HourlyWeather
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.TodayHourlyWeather
import com.example.weatherapp.logic.entity.WeatherStatus
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherDataSource(
    private val weatherApi: WeatherApi,
) {
    suspend fun getCurrentWeather(latitude: String, longitude: String): Current {
        val weatherResponse = weatherApi.getWeather(latitude, longitude)
        val todayMaxTemperature = weatherResponse.daily.temperature_2m_max[0].toInt()
        val todayMinTemperature = weatherResponse.daily.temperature_2m_min[0].toInt()

        return Current(
            temperature2m = weatherResponse.current.temperature_2m,
            weatherCode = weatherResponse.current.weather_code,
            isDay = weatherResponse.current.is_day,
            temperatureRange = Pair(todayMaxTemperature, todayMinTemperature)
        )

    }

    suspend fun getTodayWeather(latitude: String, longitude: String): List<HourlyWeather> {
        val weatherResponse = weatherApi.getWeather(latitude, longitude)
        val formatter = DateTimeFormatter.ISO_DATE_TIME

        return weatherResponse.hourly.time.indices.map { index ->
            HourlyWeather(
                time = LocalDateTime.parse(weatherResponse.hourly.time[index], formatter),
                temperature = weatherResponse.hourly.temperature_2m[index],
                weatherCode = weatherResponse.hourly.weather_code[index],
                isDay = weatherResponse.hourly.is_day[index] == 1
            )
        }
    }

    suspend fun getStatusWeather(latitude: String, longitude: String): WeatherStatus {
        val weatherResponse = weatherApi.getWeather(latitude, longitude)
        val uvIndex = weatherResponse!!.daily.uv_index_max[0]
        return WeatherStatus(
            windValue = weatherResponse!!.current.wind_speed_10m.toString(),
            humidityValue = weatherResponse.current.relative_humidity_2m.toString(),
            rainValue = weatherResponse.current.rain.toString(),
            pressureValue = weatherResponse.current.pressure_msl.toString(),
            uvValue = uvIndex.toString(),
            feelsLikeValue = weatherResponse.current.apparent_temperature.toString()
        )

    }

    suspend fun getDailyWeather(latitude: String, longitude: String): NextDays {
        val weatherResponse = weatherApi.getWeather(latitude, longitude)
        val dayNames = weatherResponse.daily.time.map {
            LocalDate.parse(it).dayOfWeek.toString()
        }
        return NextDays(
            daysNames = dayNames,
            rangeTemperatures = weatherResponse.daily.temperature_2m_max.zip(weatherResponse.daily.temperature_2m_min),
            weatherType = weatherResponse.daily.weather_code
        )


    }

}