
package com.example.week8_9no1.data.container

import com.example.week8_9no1.data.repository.WeatherRepository
import com.example.week8_9no1.data.service.WeatherApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {

    private val BASE_URL = "https://api.openweathermap.org/"

    private val okHttpClient = OkHttpClient.Builder()
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private val weatherApiService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }

    private val weatherRepository: WeatherRepository by lazy {
        WeatherRepository(weatherApiService)
    }

    fun getWeatherRepository(): WeatherRepository {
        return weatherRepository
    }
}