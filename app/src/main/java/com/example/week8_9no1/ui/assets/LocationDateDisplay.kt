package com.example.week8_9no1.ui.assets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week8_9no1.ui.model.WeatherModel

//importan java
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun LocationDateDisplay(model: WeatherModel) {
    val currentDateFormat = remember { SimpleDateFormat("MMMM dd", Locale.ENGLISH) }
    val currentTimeFormat = remember { SimpleDateFormat("hh:mm a", Locale.ENGLISH) }
    val now = remember { Date() } // Mengambil waktu saat ini

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                tint = Color.White,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = "${model.cityName}, ${model.countryCode}",
                color = Color.White,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = currentDateFormat.format(now),
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Updated as of ${currentTimeFormat.format(now)}",
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}