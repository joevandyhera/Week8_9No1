package com.example.week8_9no1.ui.assets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.week8_9no1.ui.model.WeatherModel
import com.example.week8_9no1.R // Resource ID Anda

@Composable
fun MainWeatherDisplay(model: WeatherModel) {

    val pandaDrawableId = when (model.weatherCondition.lowercase()) {
        "rain", "drizzle" -> R.drawable.panda_rain
        "clouds", "mist", "haze" -> R.drawable.panda_cloud
        "clear" -> R.drawable.panda_sunny
        else -> R.drawable.panda_sunny
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            AsyncImage(
                model = model.conditionIconUrl,
                contentDescription = model.weatherCondition,
                modifier = Modifier.size(64.dp)
            )

            Text(
                text = model.weatherCondition,
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = model.temperatureCelsius,
                color = Color.White,
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = pandaDrawableId),
                contentDescription = "Panda Cuaca: ${model.weatherCondition}",
                modifier = Modifier.size(150.dp)
            )
        }
    }
}