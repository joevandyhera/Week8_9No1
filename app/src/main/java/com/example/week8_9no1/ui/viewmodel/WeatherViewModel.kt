package com.example.week8_9no1.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week8_9no1.data.container.AppContainer
import com.example.week8_9no1.ui.model.WeatherModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class WeatherViewModel : ViewModel() {
    private val repository = AppContainer().repository

    private val _currentWeather = MutableStateFlow<WeatherModel?>(null)
    val currentWeather: StateFlow<WeatherModel?> = _currentWeather.asStateFlow()

    private val _currentView = MutableStateFlow<Views>(Views.SEARCH)
    val currentView: StateFlow<Views> = _currentView.asStateFlow()

    fun setCurrentView(view: Views) {
        _currentView.value = view
    }

    fun search(city: String) {
        if (city.isBlank()) return

        setCurrentView(Views.SEARCH)

        viewModelScope.launch {
            val result = repository.getWeather(city)

            result.onSuccess { weather ->
                _currentWeather.value = weather
                setCurrentView(Views.WEATHER)
            }.onFailure { e ->
                e.printStackTrace()
                _currentWeather.value = null
                setCurrentView(Views.NOT_FOUND)
            }
        }
    }
}