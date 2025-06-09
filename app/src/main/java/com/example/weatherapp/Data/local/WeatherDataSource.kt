package com.example.weatherapp.Data.local

import android.Manifest
import androidx.annotation.RequiresPermission
import com.example.weatherapp.Data.remote.LocationDatasource
import com.example.weatherapp.Data.remote.WeatherApi
import com.example.weatherapp.logic.entity.Current
import com.example.weatherapp.logic.entity.NextDays
import com.example.weatherapp.logic.entity.Today
import com.example.weatherapp.logic.entity.WeatherStatus
import java.time.LocalDate

class WeatherDataSource(
    private val weatherApi: WeatherApi,
    private val locationDatasource: LocationDatasource
) {
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getCurrentWeather(): Current {
        val currentCoordinates = locationDatasource.getCurrentCoordinates()
        val weatherResponse = weatherApi.getWeather(currentCoordinates?.first.toString(), currentCoordinates?.second.toString())
        val todayMaxTemperature = weatherResponse.daily.temperature_2m_max[0].toInt()
        val todayMinTemperature = weatherResponse.daily.temperature_2m_min[0].toInt()

        return Current(
            temperature2m = weatherResponse.current.temperature_2m,
            weatherCode = weatherResponse.current.weather_code,
            isDay = weatherResponse.current.is_day,
            temperatureRange = Pair(todayMaxTemperature, todayMinTemperature)
        )

    }
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getTodayWeather(): Today {
        val currentCoordinates = locationDatasource.getCurrentCoordinates()
        val weatherResponse = weatherApi.getWeather(currentCoordinates?.first.toString(), currentCoordinates?.second.toString())
        return Today(
            weatherType = weatherResponse.hourly.weather_code,
            temperatures = weatherResponse.hourly.temperature_2m,
            weatherTime = weatherResponse.hourly.time
        )
    }
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getStatusWeather(): WeatherStatus {
        val currentCoordinates = locationDatasource.getCurrentCoordinates()
        val weatherResponse = weatherApi.getWeather(currentCoordinates?.first.toString(), currentCoordinates?.second.toString())
        val uvIndex = weatherResponse.daily.uv_index_max[0]
        return WeatherStatus(
            windValue = weatherResponse.current.wind_speed_10m.toString(),
            humidityValue = weatherResponse.current.relative_humidity_2m.toString(),
            rainValue = weatherResponse.current.rain.toString(),
            pressureValue = weatherResponse.current.pressure_msl.toString(),
            uvValue = uvIndex.toString(),
            feelsLikeValue = weatherResponse.current.apparent_temperature.toString()
        )

    }
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun getDailyWeather(): NextDays {
        val currentCoordinates = locationDatasource.getCurrentCoordinates()
        val weatherResponse = weatherApi.getWeather(currentCoordinates?.first.toString(), currentCoordinates?.second.toString())
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