package com.example.weatherapp.presentation.composable

import androidx.compose.runtime.Composable
import com.example.weatherapp.R
import com.example.weatherapp.presentation.theme.WeatherTheme

object WeatherCodeMapper {
    @Composable
    fun weatherCodeToIcon(weatherCode: String): Int {
        return when (weatherCode) {
            "0" -> WeatherTheme.weatherIconPath.clearSky
            "1" -> WeatherTheme.weatherIconPath.mainlyClear
            "3" -> WeatherTheme.weatherIconPath.overcast
            "45" -> WeatherTheme.weatherIconPath.fog
            "48" -> WeatherTheme.weatherIconPath.depositingRimeFog
            "51" -> WeatherTheme.weatherIconPath.drizzle
            "53" -> WeatherTheme.weatherIconPath.drizzleModerate
            "55" -> WeatherTheme.weatherIconPath.drizzleIntensity
//            "56", "57" -> R.drawable.freezing_drizzle_light// Freezing Drizzle: Light and dense intensity
//            "61", "63", "65" -> R.drawable.rain // Rain: Slight, moderate and heavy intensity
//            "66", "67" -> R.drawable.freezing_rain // Freezing Rain: Light and heavy intensity
//            "71", "73", "75" -> R.drawable.snowfall // Snow fall: Slight, moderate, and heavy intensity
//            "77" -> R.drawable.snow_grains // Snow grains
//            "80", "81", "82" -> R.drawable.rain_showers // Rain showers: Slight, moderate, and violent
//            "85", "86" -> R.drawable.snow_showers // Snow showers slight and heavy
//            "95" -> R.drawable.thunderstorm // Thunderstorm: Slight or moderate
//            "96", "99" -> R.drawable.thunderstorm_with_hail // Thunderstorm with slight and heavy hail
            else -> WeatherTheme.weatherIconPath.clearSky // Default icon for unknown weather codes
        }
    }

    @Composable
    fun weatherCodeToIconLightTheme(weatherCode: String): Int {
        return when (weatherCode) {
            "0" ->  R.drawable.clear_sky
            "1" -> R.drawable.mainly_clear
            "3" -> R.drawable.overcast
            "45" -> R.drawable.fog
            "48" -> R.drawable.depositing_rime_fog
            "51" -> R.drawable.drizzle_light
            "53" -> R.drawable.drizzle_moderate
            "55" -> R.drawable.drizzle_intensity
//            "56", "57" -> R.drawable.freezing_drizzle_light// Freezing Drizzle: Light and dense intensity
//            "61", "63", "65" -> R.drawable.rain // Rain: Slight, moderate and heavy intensity
//            "66", "67" -> R.drawable.freezing_rain // Freezing Rain: Light and heavy intensity
//            "71", "73", "75" -> R.drawable.snowfall // Snow fall: Slight, moderate, and heavy intensity
//            "77" -> R.drawable.snow_grains // Snow grains
//            "80", "81", "82" -> R.drawable.rain_showers // Rain showers: Slight, moderate, and violent
//            "85", "86" -> R.drawable.snow_showers // Snow showers slight and heavy
//            "95" -> R.drawable.thunderstorm // Thunderstorm: Slight or moderate
//            "96", "99" -> R.drawable.thunderstorm_with_hail // Thunderstorm with slight and heavy hail
            else -> R.drawable.clear_sky // Default icon for unknown weather codes
        }
    }

    fun weatherCodeToDescription(weatherCode: Int): String {
        return when (weatherCode) {
            0 -> "Clear sky"
            1 -> "Mainly clear"
            2 -> "Partly cloudy"
            3 -> "Overcast"
            45 -> "Fog"
            48 -> "Depositing fog"
            51 -> "Drizzle"
            53 -> "Moderate drizzle"
            55 -> "Dense drizzle"
            56 -> "Freezing drizzle"
            57 -> "Dense freezing drizzle"
            61 -> "Slight Rain"
            63 -> "Moderate Rain"
            65 -> "Intensity Rain"
            71 -> "Slight Snow"
            73 -> "Moderate Snow"
            75 -> "Heavy Snow"
            77 -> "Snow grains"
            80 -> "Slight Rain Shower"
            81 -> "Moderate Rain Shower"
            82 -> "Violent Rain Shower"
            85 -> "Slight Snow Shower"
            86 -> "Heavy Snow Shower"
            95 -> "Thunderstorm"
            96 -> "Slight Hail Thunderstorm"
            99 -> "Heavy Hail Thunderstorm"
            else -> "Unknown"
        }
    }
}

fun lightIconPath(
    clearSky: Int = R.drawable.clear_sky,
    mainlyClear: Int = R.drawable.mainly_clear,
    overcast: Int = R.drawable.overcast,
    fog: Int = R.drawable.fog,
    depositingRimeFog: Int = R.drawable.depositing_rime_fog,
    drizzle: Int = R.drawable.drizzle_light,
    drizzleModerate: Int = R.drawable.drizzle_moderate,
    drizzleIntensity: Int = R.drawable.drizzle_intensity,
    freezingDrizzle: Int = R.drawable.freezing_drizzle_light,
    rainS: Int = R.drawable.rain_slight,
    rainModerate: Int = R.drawable.rain_moderate,
    rainIntensity: Int = R.drawable.rain_intensity,

) = WeatherPath(
    clearSky = clearSky,
    mainlyClear = mainlyClear,
    overcast = overcast,
    fog = fog,
    depositingRimeFog = depositingRimeFog,
    drizzle = drizzle,
    drizzleModerate = drizzleModerate,
    drizzleIntensity = drizzleIntensity,
    freezingDrizzle = freezingDrizzle,
    rainS = rainS,
    rainModerate = rainModerate,
    rainHeavy = rainIntensity,
)

fun nightIconPath(
    clearSky: Int = R.drawable.clear_sky_night,
    mainlyClear: Int = R.drawable.mainly_clear_night,
    overcast: Int = R.drawable.overcast,
    fog: Int = R.drawable.fog,
    depositingRimeFog: Int = R.drawable.depositing_rime_fog,
    drizzle: Int = R.drawable.drizzle_light_night,
    drizzleModerate: Int = R.drawable.drizzle_moderate_night,
    drizzleIntensity: Int = R.drawable.drizzle_intensity_night,
    freezingDrizzle: Int = R.drawable.freezing_drizzle_light,
    rainS: Int = R.drawable.rain_slight_night,
    rainModerate: Int = R.drawable.rain_moderate_night,
    rainIntensity: Int = R.drawable.rain_intensity_night,

    ) = WeatherPath(
    clearSky = clearSky,
    mainlyClear = mainlyClear,
    overcast = overcast,
    fog = fog,
    depositingRimeFog = depositingRimeFog,
    drizzle = drizzle,
    drizzleModerate = drizzleModerate,
    drizzleIntensity = drizzleIntensity,
    freezingDrizzle = freezingDrizzle,
    rainS = rainS,
    rainModerate = rainModerate,
    rainHeavy = rainIntensity,
)

class WeatherPath(
    val clearSky: Int,
    val mainlyClear: Int,
    val overcast: Int,
    val fog: Int,
    val depositingRimeFog: Int,
    val drizzle: Int,
    val drizzleModerate: Int,
    val drizzleIntensity: Int,
    val freezingDrizzle: Int,
    val rainS: Int,
    val rainModerate: Int,
    val rainHeavy: Int,
//    val freezingRain: Int,
//    val snowfall: Int,
//    val snowGrains: Int,
//    val rainShowers: Int,
//    val snowShowers: Int,
//    val thunderstorm: Int,
//    val thunderstormHail: Int
)
