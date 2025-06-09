package com.example.weatherapp.presentation.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherScaffold(
    appBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Column(
        Modifier.fillMaxWidth()
    ) {}
    Spacer(Modifier.height(40.dp))
    appBar()
    content()
}
