package com.example.week8_9no1.ui.model

data class WeatherModel(
    val cityName: String,
    val countryCode: String,
    val temperatureCelsius: String,
    val weatherCondition: String,
    val conditionIconUrl: String,
    val humidity: String,
    val windSpeed: String,
    val pressure: String,
    val sunriseTime: String,
    val sunsetTime: String
)