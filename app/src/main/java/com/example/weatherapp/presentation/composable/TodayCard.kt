package com.example.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.presentation.theme.WeatherTheme
import com.example.weatherapp.presentation.theme.urbanistFamily

@Composable
fun TodayCard(
    image: Painter,
    temperature: String,
    time: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = Modifier.height((120+12).dp)) {
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
                .padding(bottom = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(58.dp))
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
        Box(contentAlignment = Alignment.TopCenter,modifier = Modifier.height(64.dp).width(88.dp)){

            Box(
                modifier = Modifier
                    .offset(y = (-20).dp)
                    .size(250.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.radialGradient(
                            listOf(
                                WeatherTheme.colorScheme.todayCardImageBlurColor.copy(
                                    alpha = WeatherTheme.colorScheme.imageBlurOpacity
                                ),
                                WeatherTheme.colorScheme.todayCardImageBlurColor.copy(alpha = WeatherTheme.colorScheme.imageBlurOpacity * 0.7f),
                                WeatherTheme.colorScheme.todayCardImageBlurColor.copy(alpha = WeatherTheme.colorScheme.imageBlurOpacity * 0.01f)
                            )
                        )
                    )
                    .blur(radius = 150.dp)
            )
            Image(
                painter = image,
                contentDescription = null,
                modifier
                    .height(58.dp)
                    .offset(y = (-12).dp)
            )

        }

    }
}