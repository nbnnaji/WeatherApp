package com.nkechinnaji.simpleweatherapp.repository

import androidx.lifecycle.LiveData
import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse

interface CurrentWeatherRepository{
    fun saveCurrentWeather(weatherResponse: CurrentWeatherResponse)
    fun getAllWeatherConditions(): LiveData<CurrentWeatherResponse>
    fun clearAllWeatherData()
}