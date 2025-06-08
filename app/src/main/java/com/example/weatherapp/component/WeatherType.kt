package com.example.weatherapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.WeatherTheme
import com.example.weatherapp.ui.theme.urbanistFamily

@Composable
fun WeatherTypeContent(
    image: Painter,
    weatherDescription: String,
    weatherTemperature: String,
    temperatureRange: String
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .size(220.dp, 200.dp)
            .padding(bottom = 12.dp)
    )

    Column() {
        Text(
            weatherTemperature,
            color = WeatherTheme.colorScheme.weatherTemperatureFontColor,
            fontSize = 64.sp,
            letterSpacing = 0.25.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(600)
        )
        Text(
            weatherDescription,
            color = WeatherTheme.colorScheme.weatherDescriptionColor,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(500),
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 24.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(WeatherTheme.colorScheme.weatherRangeBoxBackgroundColor)
        ) {
            Box() {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_up_small),
                    contentDescription = null,
                    tint = WeatherTheme.colorScheme.weatherRangeIconColor,
                )
                Text(
                    temperatureRange,
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanistFamily,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Center,
                    color = WeatherTheme.colorScheme.weatherRangeFontColor,
                )
            }
            Text("|")
            Box() {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_down_small),
                    contentDescription = null,
                    tint = WeatherTheme.colorScheme.weatherRangeIconColor,
                )
                Text(
                    temperatureRange,
                    fontSize = 16.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanistFamily,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Center,
                    color = WeatherTheme.colorScheme.weatherRangeFontColor,
                )
            }
        }
    }

}