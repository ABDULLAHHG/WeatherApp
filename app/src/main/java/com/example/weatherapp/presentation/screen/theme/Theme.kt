package com.example.weatherapp.presentation.screen.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.weatherapp.presentation.screen.composable.WeatherPath
import com.example.weatherapp.presentation.screen.composable.lightIconPath
import com.example.weatherapp.presentation.screen.composable.nightIconPath

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


@Composable
fun WeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

val LocalWeatherColorScheme = staticCompositionLocalOf { lightWeatherThemeColors() }
val LocalWeatherCodeToIcon = staticCompositionLocalOf{ lightIconPath() }

//val LocalWeatherColorScheme = staticCompositionLocalOf { darkWeatherThemeColors() }
//val LocalWeatherCodeToIcon = staticCompositionLocalOf{ nightIconPath() }

object WeatherTheme {
    val colorScheme: WeatherColorScheme
        @Composable
        get() = LocalWeatherColorScheme.current
    val weatherIconPath: WeatherPath
        @Composable
        get() = LocalWeatherCodeToIcon.current
}

fun darkWeatherThemeColors(
    backgroundColor: Brush = Brush.linearGradient(listOf(Color(0xFF060414), Color(0xFF0D0C19))),
    imageBlurColor: Color = Color(0xFFC0B7FF),
    locationFontColor: Color = Color(0xFFFFFFFF),
    locationIconColor: Color = Color(0xFFFFFFFF),

    weatherTemperatureFontColor: Color = Color(0xFFFFFFFF),
    weatherDescriptionColor: Color = Color(0x99FFFFFF),
    weatherRangeBoxBackgroundColor: Color = Color(0x14FFFFFF),
    weatherRangeFontColor: Color = Color(0xDEFFFFFF),
    weatherRangeIconColor: Color = Color(0xDEFFFFFF),

    statusCardBackgroundColor: Color = Color(0xB2060414),
    statusCardBorderColor: Color = Color(0x14FFFFFF),
    statusCardValueFontColor: Color = Color(0xDEFFFFFF),
    statusCardTitleFontColor: Color = Color(0x99FFFFFF),

    todayLabelFontColor: Color = Color(0xFFFFFFFF),
    todayCardBackgroundColor: Color = Color(0xB2060414),
    todayCardBorderColor: Color = Color(0x14FFFFFF),
    todayCardValueFontColor: Color = Color(0xDEFFFFFF),
    todayCardTitleFontColor: Color = Color(0x99FFFFFF),

    nextDaysLabelFontColor: Color = Color(0xFFFFFFFF),
    nextDaysCardTitleFontColor: Color = Color(0x99FFFFFF),
    nextDaysCardValueFontColor: Color = Color(0xDEFFFFFF),
    nextDaysCardValueBorderLineFontColor: Color = Color(0x14FFFFFF),
    nextDaysCardBorderColor: Color = Color(0x14FFFFFF),
    nextDaysCardBackgroundColor: Color = Color(0xB2060414),
    nextDaysCardIconColor: Color = Color(0xDEFFFFFF),

    ): WeatherColorScheme =
    WeatherColorScheme(
        backgroundColor,
        imageBlurColor,
        locationFontColor,
        locationIconColor,
        weatherTemperatureFontColor,
        weatherDescriptionColor,
        weatherRangeBoxBackgroundColor,
        weatherRangeFontColor,
        weatherRangeIconColor,
        statusCardBackgroundColor,
        statusCardBorderColor,
        statusCardValueFontColor,
        statusCardTitleFontColor,
        todayLabelFontColor,
        todayCardBackgroundColor,
        todayCardBorderColor,
        todayCardValueFontColor,
        todayCardTitleFontColor,
        nextDaysLabelFontColor,
        nextDaysCardTitleFontColor,
        nextDaysCardValueFontColor,
        nextDaysCardValueBorderLineFontColor,
        nextDaysCardBorderColor,
        nextDaysCardBackgroundColor,
        nextDaysCardIconColor,
    )


fun lightWeatherThemeColors(
    backgroundColor: Brush = Brush.linearGradient(listOf(Color(0xFF87CEFA), Color(0xFFFFFFFF))),
    imageBlurColor: Color = Color(0xFF00619D),
    locationFontColor: Color = Color(0xFF323232),
    locationIconColor: Color = Color(0xFF323232),

    weatherTemperatureFontColor: Color = Color(0xFF060414),
    weatherDescriptionColor: Color = Color(0x99060414),
    weatherRangeBoxBackgroundColor: Color = Color(0x14060414),
    weatherRangeFontColor: Color = Color(0x99060414),
    weatherRangeIconColor: Color = Color(0x99060414),

    statusCardBackgroundColor: Color = Color(0xB2FFFFFF),
    statusCardBorderColor: Color = Color(0x14060414),
    statusCardValueFontColor: Color = Color(0xDE060414),
    statusCardTitleFontColor: Color = Color(0x99060414),

    todayLabelFontColor: Color = Color(0xFF060414),
    todayCardBackgroundColor: Color = Color(0xB2FFFFFF),
    todayCardBorderColor: Color = Color(0x14060414),
    todayCardValueFontColor: Color = Color(0xDE060414),
    todayCardTitleFontColor: Color = Color(0x99060414),

    nextDaysLabelFontColor: Color = Color(0xFF060414),
    nextDaysCardTitleFontColor: Color = Color(0x99060414),
    nextDaysCardValueFontColor: Color = Color(0xDE060414),
    nextDaysCardValueBorderLineFontColor: Color = Color(0x14060414),
    nextDaysCardBorderColor: Color = Color(0x14060414),
    nextDaysCardBackgroundColor: Color = Color(0xB2FFFFFF),
    nextDaysCardIconColor: Color = Color(0x14060414),

    ): WeatherColorScheme =
    WeatherColorScheme(
        backgroundColor,
        imageBlurColor,
        locationFontColor,
        locationIconColor,
        weatherTemperatureFontColor,
        weatherDescriptionColor,
        weatherRangeBoxBackgroundColor,
        weatherRangeFontColor,
        weatherRangeIconColor,
        statusCardBackgroundColor,
        statusCardBorderColor,
        statusCardValueFontColor,
        statusCardTitleFontColor,
        todayLabelFontColor,
        todayCardBackgroundColor,
        todayCardBorderColor,
        todayCardValueFontColor,
        todayCardTitleFontColor,
        nextDaysLabelFontColor,
        nextDaysCardTitleFontColor,
        nextDaysCardValueFontColor,
        nextDaysCardValueBorderLineFontColor,
        nextDaysCardBorderColor,
        nextDaysCardBackgroundColor,
        nextDaysCardIconColor,
    )


// color scheme
class WeatherColorScheme(
    val appBackgroundColor: Brush,
    val imageBlurColor: Color,

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

    val nextDaysLabelFontColor: Color,
    val nextDaysCardTitleFontColor: Color,
    val nextDaysCardValueFontColor: Color,
    val nextDaysCardValueBorderLineFontColor: Color,
    val nextDaysCardBorderColor: Color,
    val nextDaysCardBackgroundColor: Color,
    val nextDaysCardIconColor: Color,

    ) {

}