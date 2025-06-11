package com.example.weatherapp.presentation.theme

import androidx.compose.runtime.Composable
import com.example.weatherapp.R

object WeatherCodeMapper {

    @Composable
    fun weatherCodeToIcon(weatherCode: String): Int {
        val weatherIconPath = WeatherTheme.weatherIconPath

        return when (weatherCode) {
            "0" -> weatherIconPath.clearSky
            "1" -> weatherIconPath.mainlyClear
            "3" -> weatherIconPath.overcast
            "45" -> weatherIconPath.fog
            "48" -> weatherIconPath.depositingRimeFog
            "51" -> weatherIconPath.drizzle
            "53" -> weatherIconPath.drizzleModerate
            "55" -> weatherIconPath.drizzleIntensity
            "56" -> weatherIconPath.freezingDrizzle
            "57" -> weatherIconPath.freezingDrizzleIntensity
            "61" -> weatherIconPath.rainS
            "63" -> weatherIconPath.rainModerate
            "65" -> weatherIconPath.rainHeavy
            "71" -> weatherIconPath.snowFallLight
            "73" -> weatherIconPath.snowFallModerate
            "77" -> weatherIconPath.snowGrains
            "80" -> weatherIconPath.rainShowerSlight
            "81" -> weatherIconPath.rainShowerModerate
            "82" -> weatherIconPath.rainShowerViolent
            "85" -> weatherIconPath.snowShowerSlight
            "86" -> weatherIconPath.snowShowerHeavy
            "95" -> weatherIconPath.thunderstormSlightHail
            "96" -> weatherIconPath.thunderstormSlightHail
            "99" -> weatherIconPath.thunderstormHeavyHail
            else -> weatherIconPath.default
        }
    }

    @Composable
    fun weatherCodeToIconLightTheme(weatherCode: String): Int {
        return when (weatherCode) {
            "0" -> R.drawable.clear_sky
            "1" -> R.drawable.mainly_clear
            "3" -> R.drawable.overcast
            "45" -> R.drawable.fog
            "48" -> R.drawable.depositing_rime_fog
            "51" -> R.drawable.drizzle_light
            "53" -> R.drawable.drizzle_moderate
            "55" -> R.drawable.drizzle_intensity
            "56" -> R.drawable.freezing_drizzle_light
            "57" -> R.drawable.freezing_drizzle_light
            "61" -> R.drawable.rain_slight
            "63" -> R.drawable.rain_moderate
            "65" -> R.drawable.rain_intensity
            "71" -> R.drawable.snow_fall_light
            "73" -> R.drawable.snow_fall_moderate
            "75" -> R.drawable.snow_fall_light
            "77" -> R.drawable.snow_grains
            "80" -> R.drawable.rain_shower_slight_day
            "81" -> R.drawable.rain_shower_moderate_day
            "82" -> R.drawable.rain_shower_violent_day
            "85" -> R.drawable.snow_shower_slight_day
            "86" -> R.drawable.snow_shower_heavy_day
            "95" -> R.drawable.thunderstorem_with_slight_hail_day
            "96" -> R.drawable.thunderstrom_with_heavy_hail_day
            "99" -> R.drawable.thunderstrom_with_heavy_hail_day
            else -> R.drawable.clear_sky
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


fun dayIconPath(
    clearSky: Int = R.drawable.clear_sky_day,
    mainlyClear: Int = R.drawable.mainly_clear_day,
    partilyCloudy: Int = R.drawable.partily_cloudy_day,
    overcast: Int = R.drawable.overcast_day,
    fog: Int = R.drawable.fog_day,
    depositingRimeFog: Int = R.drawable.depositing_rime_fog_day,
    drizzle: Int = R.drawable.drizzle_light_day,
    drizzleModerate: Int = R.drawable.drizzle_moderate_day,
    drizzleIntensity: Int = R.drawable.drizzle_intensity_day,
    freezingDrizzle: Int = R.drawable.freezing_drizzle_light_day,
    freezingDrizzleIntensity: Int = R.drawable.freezing_drizzle_intensity_day,
    rainS: Int = R.drawable.rain_slight_day,
    rainModerate: Int = R.drawable.rain_moderate_day,
    rainHeavy: Int = R.drawable.rain_intensity_day,
    snowFallLight: Int = R.drawable.snow_fall_light,
    snowFallModerate: Int = R.drawable.snow_fall_moderate_day,
    snowGrains: Int = R.drawable.snow_grains_day,
    rainShowerSlight: Int = R.drawable.rain_shower_slight_day,
    rainShowerModerate: Int = R.drawable.rain_shower_moderate_day,
    rainShowerViolent: Int = R.drawable.rain_shower_violent_day,
    snowShowerSlight: Int = R.drawable.snow_shower_slight_day,
    snowShowerHeavy: Int = R.drawable.snow_shower_heavy_day,
    thunderstormSlightHail: Int = R.drawable.thunderstorem_with_slight_hail_day,
    thunderstormHeavyHail: Int = R.drawable.thunderstrom_with_heavy_hail_day,
    default: Int = R.drawable.clear_sky_day
) = WeatherPath(
    clearSky = clearSky,
    mainlyClear = mainlyClear,
    partilyCloudy = partilyCloudy,
    overcast = overcast,
    fog = fog,
    depositingRimeFog = depositingRimeFog,
    drizzle = drizzle,
    drizzleModerate = drizzleModerate,
    drizzleIntensity = drizzleIntensity,
    freezingDrizzle = freezingDrizzle,
    freezingDrizzleIntensity = freezingDrizzleIntensity,
    rainS = rainS,
    rainModerate = rainModerate,
    rainHeavy = rainHeavy,
    snowFallLight = snowFallLight,
    snowFallModerate = snowFallModerate,
    snowGrains = snowGrains,
    rainShowerSlight = rainShowerSlight,
    rainShowerModerate = rainShowerModerate,
    rainShowerViolent = rainShowerViolent,
    snowShowerSlight = snowShowerSlight,
    snowShowerHeavy = snowShowerHeavy,
    thunderstormSlightHail = thunderstormSlightHail,
    thunderstormHeavyHail = thunderstormHeavyHail,
    default = default
)

fun nightIconPath(
    clearSky: Int = R.drawable.clear_sky_night,
    mainlyClear: Int = R.drawable.mainly_clear_night,
    partlyCloudy: Int = R.drawable.partly_cloudy_night,
    overcast: Int = R.drawable.overcast_night,
    fog: Int = R.drawable.fog_night,
    depositingRimeFog: Int = R.drawable.deposting_rime_fog_night,
    drizzle: Int = R.drawable.drizzle_light_night,
    drizzleModerate: Int = R.drawable.drizzle_moderate_night,
    drizzleIntensity: Int = R.drawable.drizzle_intensity_night,
    freezingDrizzle: Int = R.drawable.freezing_drizzle_light_night,
    freezingDrizzleIntensity: Int = R.drawable.freezing_drizzle_intensity_night,
    rainS: Int = R.drawable.rain_light_night,
    rainModerate: Int = R.drawable.rain_moderate_night,
    rainHeavy: Int = R.drawable.rain_heavy_night,
    snowFallLight: Int = R.drawable.snow_fall_light_night,
    snowFallModerate: Int = R.drawable.snow_fall_moderate_night,
    snowGrains: Int = R.drawable.snow_grains_night,
    rainShowerSlight: Int = R.drawable.rain_shower_light_night,
    rainShowerModerate: Int = R.drawable.rain_shower_moderate_night,
    rainShowerViolent: Int = R.drawable.rain_shower_violent_night,
    snowShowerSlight: Int = R.drawable.snow_shower_slight_night,
    snowShowerHeavy: Int = R.drawable.snow_shower_heavy_night,
    thunderstormSlightHail: Int = R.drawable.thunderstorm_with_slight_hail_night,
    thunderstormHeavyHail: Int = R.drawable.thunderstrom_with_heavy_hail_night,
    default: Int = R.drawable.clear_sky_night
) = WeatherPath(
    clearSky = clearSky,
    mainlyClear = mainlyClear,
    partilyCloudy = partlyCloudy,
    overcast = overcast,
    fog = fog,
    depositingRimeFog = depositingRimeFog,
    drizzle = drizzle,
    drizzleModerate = drizzleModerate,
    drizzleIntensity = drizzleIntensity,
    freezingDrizzle = freezingDrizzle,
    freezingDrizzleIntensity = freezingDrizzleIntensity,
    rainS = rainS,
    rainModerate = rainModerate,
    rainHeavy = rainHeavy,
    snowFallLight = snowFallLight,
    snowFallModerate = snowFallModerate,
    snowGrains = snowGrains,
    rainShowerSlight = rainShowerSlight,
    rainShowerModerate = rainShowerModerate,
    rainShowerViolent = rainShowerViolent,
    snowShowerSlight = snowShowerSlight,
    snowShowerHeavy = snowShowerHeavy,
    thunderstormSlightHail = thunderstormSlightHail,
    thunderstormHeavyHail = thunderstormHeavyHail,
    default = default,

    )


data class WeatherPath(
    val clearSky: Int,
    val mainlyClear: Int,
    val partilyCloudy: Int,
    val overcast: Int,
    val fog: Int,
    val depositingRimeFog: Int,
    val drizzle: Int,
    val drizzleModerate: Int,
    val drizzleIntensity: Int,
    val freezingDrizzle: Int,
    val freezingDrizzleIntensity: Int,
    val rainS: Int,
    val rainModerate: Int,
    val rainHeavy: Int,
    val snowFallLight: Int,
    val snowFallModerate: Int,
    val snowGrains: Int,
    val rainShowerSlight: Int,
    val rainShowerModerate: Int,
    val rainShowerViolent: Int,
    val snowShowerSlight: Int,
    val snowShowerHeavy: Int,
    val thunderstormSlightHail: Int,
    val thunderstormHeavyHail: Int,
    val default: Int,
)