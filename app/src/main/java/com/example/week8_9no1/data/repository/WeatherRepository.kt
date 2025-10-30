// data/repository/WeatherRepository.kt

package com.example.week8_9no1.data.repository

import com.example.week8_9no1.data.dto.Weather
import com.example.week8_9no1.data.service.WeatherApiService
import com.example.week8_9no1.ui.model.WeatherModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

class WeatherRepository(private val apiService: WeatherApiService) {

    suspend fun getWeather(city: String): Result<WeatherModel> {
        return try {
            val dto = apiService.getCurrentWeather(city)

            Result.success(mapDtoToModel(dto))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    private fun mapDtoToModel(dto: Weather): WeatherModel {

        val tempKelvin = dto.main.temp

        val tempC = (tempKelvin - 273.15).toInt()

        val windSpeedKmH = (dto.wind.speed * 3.6).toInt()
        val condition = dto.weather.firstOrNull()?.main ?: "Clear"
        val iconCode = dto.weather.firstOrNull()?.icon ?: "01d"

        val iconUrl = "https://openweathermap.org/img/wn/$iconCode@2x.png"

        val sunrise = convertTimestampToTime(dto.sys.sunrise.toLong(), dto.timezone)
        val sunset = convertTimestampToTime(dto.sys.sunset.toLong(), dto.timezone)

        return WeatherModel(
            cityName = dto.name,
            countryCode = dto.sys.country,
            temperatureCelsius = "$tempC°C",
            weatherCondition = condition,
            conditionIconUrl = iconUrl,
            humidity = "${dto.main.humidity}%",
            windSpeed = "$windSpeedKmH km/h",
            pressure = "${dto.main.pressure} hPa",
            sunriseTime = sunrise,
            sunsetTime = sunset
        )
    }

    private fun convertTimestampToTime(timestamp: Long, timezoneOffset: Int): String {
        val sdf = SimpleDateFormat("h:mm a")
        val date = Date(timestamp * 1000L)

        val tz = TimeZone.getTimeZone("GMT").apply { rawOffset = timezoneOffset * 1000 }
        sdf.timeZone = tz

        return sdf.format(date)
    }
}