package com.example.weatherapp.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherTheme
import com.example.weatherapp.ui.theme.urbanistFamily

@Composable
fun TodayCard(
    image: Painter,
    temperature: String,
    time: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(88.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(WeatherTheme.colorScheme.todayCardBackgroundColor)
            .border(
                1.dp,
                color = WeatherTheme.colorScheme.todayCardBorderColor,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier
                .height(58.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            temperature,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(500),
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.todayCardValueFontColor
        )
        Text(
            time, fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(500),
            textAlign = TextAlign.Center,
            color = WeatherTheme.colorScheme.todayCardTitleFontColor
        )
    }
}