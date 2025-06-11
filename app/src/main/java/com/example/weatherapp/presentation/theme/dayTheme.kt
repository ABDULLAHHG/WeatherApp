package com.example.weatherapp.presentation.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


fun dayWeatherThemeColors(
    backgroundColor: Brush = Brush.verticalGradient(listOf(Color(0xFF87CEFA), Color(0xFFFFFFFF))),
    imageBlurColor: Color = Color(0xFF00619D),
    imageBlurOpacity: Float = 0.32f,
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
    todayCardImageBlurColor: Color = Color(0x00FFFFFF),

    nextDaysLabelFontColor: Color = Color(0xFF060414),
    nextDaysCardTitleFontColor: Color = Color(0x99060414),
    nextDaysCardValueBorderLineFontColor: Color = Color(0x14060414),
    nextDaysCardBorderColor: Color = Color(0x14060414),
    nextDaysCardBackgroundColor: Color = Color(0xB2FFFFFF),

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
