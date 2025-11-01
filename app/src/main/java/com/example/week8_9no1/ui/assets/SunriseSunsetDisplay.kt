package com.example.week8_9no1.ui.assets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week8_9no1.ui.model.WeatherModel
import com.example.week8_9no1.R
import java.util.Locale

@Composable
fun SunriseSunsetDisplay(model: WeatherModel) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.sunrise),
                modifier = Modifier.size(24.dp),
                contentDescription = "Sunrise"
            )

            Text("SUNRISE", color = Color.Gray.copy(0.7f), fontSize = 10.sp)

            Text(
                text = model.sunriseTime.uppercase(Locale.ROOT),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.sunset),
                modifier = Modifier.size(24.dp),
                contentDescription = "Sunset"
            )

            Text("SUNSET", color = Color.Gray.copy(0.7f), fontSize = 10.sp)

            Text(
                text = model.sunsetTime.uppercase(Locale.ROOT),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}