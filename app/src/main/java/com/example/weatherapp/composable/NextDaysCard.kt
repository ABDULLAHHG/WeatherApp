package com.example.weatherapp.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.WeatherTheme
import com.example.weatherapp.ui.theme.urbanistFamily

@Composable
fun NextDaysCard(
    dayName: String,
    image: Painter,
    temperatureRange: String,

    modifier: Modifier = Modifier
) {
    Row(modifier.height(61.dp).fillMaxWidth()) {
        Text(
            dayName,
            modifier.width(91.dp),
            fontSize = 16.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(400),
            letterSpacing = 0.25.sp,
            color = WeatherTheme.colorScheme.nextDaysCardTitleFontColor
            )
        Image(image, contentDescription = null)
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