package com.example.weatherapp.presentation.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun nightWeatherThemeColors(
    backgroundColor: Brush = Brush.verticalGradient(listOf(Color(0xFF060414), Color(0xFF0D0C19))),
    imageBlurColor: Color = Color(0xFFC0B7FF),
    imageBlurOpacity: Float = 0.2f,
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
    todayCardImageBlurColor: Color = Color(0xFFC0B7FF),

    nextDaysLabelFontColor: Color = Color(0xFFFFFFFF),
    nextDaysCardTitleFontColor: Color = Color(0x99FFFFFF),
    nextDaysCardValueBorderLineFontColor: Color = Color(0x14FFFFFF),
    nextDaysCardBorderColor: Color = Color(0x14FFFFFF),
    nextDaysCardBackgroundColor: Color = Color(0xB2060414),

    ): WeatherColorScheme =
    WeatherColorScheme(
        appBackgroundColor = backgroundColor,
        imageBlurColor = imageBlurColor,
        imageBlurOpacity = imageBlurOpacity,
        locationFontColor = locationFontColor,
        locationIconColor = locationIconColor,
        weatherTemperatureFontColor = weatherTemperatureFontColor,
        weatherDescriptionColor = weatherDescriptionColor,
        weatherRangeBoxBackgroundColor = weatherRangeBoxBackgroundColor,
        weatherRangeFontColor = weatherRangeFontColor,
        weatherRangeIconColor = weatherRangeIconColor,
        statusCardBackgroundColor = statusCardBackgroundColor,
        statusCardBorderColor = statusCardBorderColor,
        statusCardValueFontColor = statusCardValueFontColor,
        statusCardTitleFontColor = statusCardTitleFontColor,
        todayLabelFontColor = todayLabelFontColor,
        todayCardBackgroundColor = todayCardBackgroundColor,
        todayCardBorderColor = todayCardBorderColor,
        todayCardValueFontColor = todayCardValueFontColor,
        todayCardTitleFontColor = todayCardTitleFontColor,
        todayCardImageBlurColor = todayCardImageBlurColor,
        nextDaysLabelFontColor = nextDaysLabelFontColor,
        nextDaysCardTitleFontColor = nextDaysCardTitleFontColor,
        nextDaysCardValueBorderLineFontColor = nextDaysCardValueBorderLineFontColor,
        nextDaysCardBorderColor = nextDaysCardBorderColor,
        nextDaysCardBackgroundColor = nextDaysCardBackgroundColor,
    )
