package com.example.week8_9no1.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.week8_9no1.ui.model.WeatherModel
import com.example.week8_9no1.ui.assets.LocationDateDisplay
import com.example.week8_9no1.ui.assets.MainWeatherDisplay
import com.example.week8_9no1.ui.assets.SunriseSunsetDisplay
import com.example.week8_9no1.ui.assets.WeatherDetailsGrid



@Composable
fun WeatherView(model: WeatherModel) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp),
        contentPadding = PaddingValues(bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        item {
            LocationDateDisplay(model)
        }

        item {
            MainWeatherDisplay(model)
        }

        item {
            WeatherDetailsGrid(model)
        }

        item {
            SunriseSunsetDisplay(model)
        }
    }
}