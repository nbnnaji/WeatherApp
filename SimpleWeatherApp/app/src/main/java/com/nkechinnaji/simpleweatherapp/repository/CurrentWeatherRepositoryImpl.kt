package com.nkechinnaji.simpleweatherapp.repository

import com.nkechinnaji.simpleweatherapp.network.CurrentWeatherServiceImpl

class CurrentWeatherRepositoryImpl(private val currentWeatherServiceImpl: CurrentWeatherServiceImpl) {
    suspend fun getCurrentWeather(accessKey: String, query: String) = currentWeatherServiceImpl.getCurrentWeather(accessKey = accessKey, query = query )
}