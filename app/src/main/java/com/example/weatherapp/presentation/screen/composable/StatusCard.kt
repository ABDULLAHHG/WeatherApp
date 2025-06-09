package com.example.weatherapp.presentation.screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.presentation.screen.theme.WeatherTheme
import com.example.weatherapp.presentation.screen.theme.urbanistFamily

@Composable
fun StatusCard(
    image: ImageVector,
    value: String,
    statusType: String,
    modifier: Modifier = Modifier,
    imageSize: Int = 32,
    color: Color = Color(0xFF87CEFA),

    ) {
    Column(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(WeatherTheme.colorScheme.statusCardBackgroundColor)
            .border(
                1.dp,
                WeatherTheme.colorScheme.statusCardBorderColor,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = image,
            contentDescription = null,
            tint = color,
            modifier = Modifier
                .size(imageSize.dp)
                .padding(bottom = 8.dp)
        )
        Column() {
            Text(
                value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp),
                fontSize = 20.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(500),
                color = WeatherTheme.colorScheme.statusCardValueFontColor
            )
            Text(
                statusType,
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(400),
                modifier = Modifier.fillMaxWidth(),
                color = WeatherTheme.colorScheme.statusCardTitleFontColor
            )
        }
    }
}