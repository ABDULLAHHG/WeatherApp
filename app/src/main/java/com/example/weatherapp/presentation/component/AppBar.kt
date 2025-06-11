package com.example.weatherapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.theme.WeatherTheme
import com.example.weatherapp.presentation.theme.urbanistFamily
import com.example.weatherapp.presentation.viewModel.LocationViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppBar(
    viewModel: LocationViewModel = koinViewModel()
) {
    val state by viewModel.statusValue.collectAsState()
    AppBarContent(state)
}

@Composable
fun AppBarContent(text: String) {
    Spacer(modifier = Modifier.height(24.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.location),
            contentDescription = null,
            tint = WeatherTheme.colorScheme.locationIconColor
        )
        Text(
            text = text,
            color = WeatherTheme.colorScheme.locationFontColor,
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            lineHeight = 20.sp,
            fontFamily = urbanistFamily,
            letterSpacing = 0.25.sp
        )

    }

}