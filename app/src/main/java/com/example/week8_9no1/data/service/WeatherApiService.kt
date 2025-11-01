package com.example.week8_9no1.data.service

import com.example.week8_9no1.data.dto.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("data/2.5/weather")

    suspend fun getCurrentWeather(
        @Query("q") city: String,

        @Query("appid") apiKey: String
    ): Weather
}