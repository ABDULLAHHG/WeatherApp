package com.example.weatherapp.Data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class WeatherApi {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                encodeDefaults = true
            })
        }
    }

    suspend fun getWeather(latitude: String, longitude: String): WeatherResponse {
        val response: HttpResponse = client.get {
            url("https://api.open-meteo.com/v1/forecast?latitude=$latitude&longitude=$longitude&daily=temperature_2m_max,temperature_2m_min,weather_code,uv_index_max&hourly=temperature_2m,weather_code,is_day&current=temperature_2m,wind_speed_10m,relative_humidity_2m,rain,weather_code,apparent_temperature,pressure_msl,is_day,precipitation")

        }
        return response.body<WeatherResponse>()


    }

    @Serializable
    data class WeatherResponse(
        val latitude: Double,
        val longitude: Double,
        val generationtime_ms: Double,
        val utc_offset_seconds: Int,
        val timezone: String,
        val timezone_abbreviation: String,
        val elevation: Double,
        val current: Current,
        val hourly: Hourly,
        val daily: Daily
    )


    @Serializable
    data class Current(
        val time: String,
        val interval: Int,
        val temperature_2m: Double,
        val wind_speed_10m: Double,
        val relative_humidity_2m: Int,
        val rain: Double,
        val weather_code: Int,
        val apparent_temperature: Double,
        val pressure_msl: Double,
        val is_day: Int,
        val precipitation: Double
    )


    @Serializable
    data class Hourly(
        val time: List<String>,
        val temperature_2m: List<Double>,
        val weather_code: List<Int>,
        val is_day: List<Int>
    )

    @Serializable
    data class Daily(
        val time: List<String>,
        val temperature_2m_max: List<Double>,
        val temperature_2m_min: List<Double>,
        val weather_code: List<Int>,
        val uv_index_max: List<Double>
    )

}

