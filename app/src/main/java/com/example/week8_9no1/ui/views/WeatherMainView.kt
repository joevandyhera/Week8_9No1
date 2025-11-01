package com.example.week8_9no1.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week8_9no1.ui.viewmodel.WeatherViewModel
import com.example.week8_9no1.ui.viewmodel.Views
import com.example.week8_9no1.ui.components.SearchBar
import com.example.week8_9no1.R

@Composable
fun WeatherMainView() {
    val viewModel: WeatherViewModel = viewModel()

    val currentView by viewModel.currentView.collectAsState()
    val weatherData by viewModel.currentWeather.collectAsState()

    var cityInput by remember { mutableStateOf("") }

    val fallbackBackgroundColor = Color(0xFF1E2749)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(fallbackBackgroundColor)
    ) {
        Image(
            painter = painterResource(R.drawable.weather_home_2),
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )

        Scaffold(
            containerColor = Color.Transparent,
            contentColor = Color.White,
            topBar = {
                Column(
                    modifier = Modifier
                        .windowInsetsPadding(WindowInsets.safeDrawing)
                        .padding(horizontal = 22.dp)
                ) {
                    SearchBar(
                        query = cityInput,
                        onQueryChange = { cityInput = it },
                        onSearch = { viewModel.search(it) }
                    )
                }
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 22.dp)
            ) {
                when (currentView) {
                    Views.SEARCH -> SearchHomeView()

                    Views.NOT_FOUND -> NotFoundView()

                    Views.WEATHER -> {
                        weatherData?.let { model ->
                            WeatherView(model = model)
                        } ?: SearchHomeView()
                    }
                }
            }
        }
    }
}