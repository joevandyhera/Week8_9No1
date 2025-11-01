package com.example.week8_9no1.ui.views

import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.Column

@Composable
fun NotFoundView() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 20.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = null,
            modifier = Modifier
                .size(60.dp),
            tint = Color.Red
        )

        Text(
            text = "Oops! Something went wrong",
            color = Color.White,
            fontSize = 18.sp
        )

        Text(
            text = "HTTP 404 Not Found",
            color = Color.White.copy(0.5f),
            fontSize = 14.sp
        )
    }
}