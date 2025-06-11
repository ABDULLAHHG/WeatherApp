package com.example.weatherapp.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.weatherapp.presentation.viewModel.TodayHourlyThemeViewModel
import org.koin.androidx.compose.koinViewModel

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)


// Theme.kt
val LightColors = lightColorScheme(
    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
)

val DarkColors = darkColorScheme(
    primary = Color(0xFFBB86FC),
    onPrimary = Color.Black,
)

val LocalWeatherColorScheme = staticCompositionLocalOf { dayWeatherThemeColors() }
val LocalWeatherCodeToIcon = staticCompositionLocalOf { dayIconPath() }

@Composable
fun WeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    viewModel: TodayHourlyThemeViewModel = koinViewModel(),
    content: @Composable () -> Unit
) {
    val state by viewModel.statusValue.collectAsState()

    val weatherColorScheme = if (state) {
        dayWeatherThemeColors()
    } else {
        nightWeatherThemeColors()
    }

    val weatherIconPath = if (state) {
        dayIconPath()
    } else {
        nightIconPath()
    }

    val materialColorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalWeatherColorScheme provides weatherColorScheme,
        LocalWeatherCodeToIcon provides weatherIconPath
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = Typography,
            content = content
        )
    }
}


object WeatherTheme {
    val colorScheme: WeatherColorScheme
        @Composable
        get() = LocalWeatherColorScheme.current
    val weatherIconPath: WeatherPath
        @Composable
        get() = LocalWeatherCodeToIcon.current
}


// color scheme
class WeatherColorScheme(

    val appBackgroundColor: Brush,

    val imageBlurColor: Color,
    val imageBlurOpacity: Float,

    val locationFontColor: Color,
    val locationIconColor: Color,

    val weatherTemperatureFontColor: Color,
    val weatherDescriptionColor: Color,
    val weatherRangeBoxBackgroundColor: Color,
    val weatherRangeFontColor: Color,
    val weatherRangeIconColor: Color,

    val statusCardBackgroundColor: Color,
    val statusCardBorderColor: Color,
    val statusCardValueFontColor: Color,
    val statusCardTitleFontColor: Color,

    val todayLabelFontColor: Color,
    val todayCardBackgroundColor: Color,
    val todayCardBorderColor: Color,
    val todayCardValueFontColor: Color,
    val todayCardTitleFontColor: Color,
    val todayCardImageBlurColor: Color,

    val nextDaysLabelFontColor: Color,
    val nextDaysCardTitleFontColor: Color,
    val nextDaysCardValueBorderLineFontColor: Color,
    val nextDaysCardBorderColor: Color,
    val nextDaysCardBackgroundColor: Color,
)