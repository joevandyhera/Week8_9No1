package com.example.week8_9no1.ui.assets

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.week8_9no1.ui.model.WeatherModel
import com.example.week8_9no1.ui.components.StatCard
import com.example.week8_9no1.R

data class WeatherStat(
    val imageId: Int,
    val label: String,
    val value: String
)

@Composable
fun WeatherDetailsGrid(model: WeatherModel) {

    val stats = listOf(
        WeatherStat(R.drawable.icon_humidity, "HUMIDITY", model.humidity),
        WeatherStat(R.drawable.icon_wind, "WIND", model.windSpeed),
        WeatherStat(R.drawable.icon_feels_like, "FEELS LIKE", "32°"),

        WeatherStat(R.drawable.icon_rainfall, "RAIN FALL", "0.0 mm"),
        WeatherStat(R.drawable.devices, "PRESSURE", model.pressure),
        WeatherStat(R.drawable.clouds, "CLOUDS", "8%"),
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        stats.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowItems.forEach { stat ->
                    StatCard(
                        imageId = stat.imageId,
                        label = stat.label,
                        content = stat.value,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}