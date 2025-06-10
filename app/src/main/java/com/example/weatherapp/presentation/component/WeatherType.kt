package com.example.weatherapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.composable.WeatherCodeMapper
import com.example.weatherapp.presentation.theme.WeatherTheme
import com.example.weatherapp.presentation.theme.urbanistFamily
import com.example.weatherapp.presentation.viewModel.CurrentWeatherViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CurrentWeather(
    viewModel: CurrentWeatherViewModel = koinViewModel()
) {
    val state by viewModel.statusValue.collectAsState()
    CurrentWeatherContent(
        image = painterResource(id = WeatherCodeMapper.weatherCodeToIcon(state.image)),
        weatherDescription = state.weatherDescription,
        weatherTemperature = state.weatherTemperature,
        temperatureRange = state.temperatureRange
    )
}
// precipitation_probability

@Composable
fun CurrentWeatherContent(
    image: Painter,
    weatherDescription: String,
    weatherTemperature: String,
    temperatureRange: Pair<String, String>
) {
    Box() {
        Box(
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape)
                .background(brush = Brush.radialGradient(listOf(WeatherTheme.colorScheme.imageBlurColor.copy(alpha = 0.32f), WeatherTheme.colorScheme.imageBlurColor.copy(alpha = 0.32f*0.7f), WeatherTheme.colorScheme.imageBlurColor.copy(alpha = 0.32f*0.01f))))
                .blur(radius = 75.dp,)
                .align(Alignment.TopCenter)
                .offset(y = -100.dp))


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {


            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(220.dp, 200.dp)
                    .padding(bottom = 12.dp)
            )
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
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(WeatherTheme.colorScheme.weatherRangeBoxBackgroundColor)
                    .padding(vertical = 8.dp, horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(3.5.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_up_small),
                        contentDescription = null,
                        tint = WeatherTheme.colorScheme.weatherRangeIconColor,
                    )
                    Text(
                        temperatureRange.second,
                        fontSize = 16.sp,
                        letterSpacing = 0.25.sp,
                        fontFamily = urbanistFamily,
                        fontWeight = FontWeight(500),
                        textAlign = TextAlign.Center,
                        color = WeatherTheme.colorScheme.weatherRangeFontColor,
                    )
                }
                VerticalDivider(
                    thickness = 1.dp,
                    color = WeatherTheme.colorScheme.nextDaysCardValueBorderLineFontColor,
                    modifier = Modifier.height(14.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(3.5.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_down_small),
                        contentDescription = null,
                        tint = WeatherTheme.colorScheme.weatherRangeIconColor,
                    )
                    Text(
                        temperatureRange.first,
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

}