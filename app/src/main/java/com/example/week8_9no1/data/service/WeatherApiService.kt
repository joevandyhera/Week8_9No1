package com.example.week8_9no1.data.service

import com.example.week8_9no1.data.dto.Weather
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "199d39cbaad32e3acffa0001c5c70afa"

interface WeatherApiService {

    @GET("data/2.5/weather")

    suspend fun getCurrentWeather(
        @Query("q") city: String,

        @Query("appid") apiKey: String = API_KEY
    ): Weather
}