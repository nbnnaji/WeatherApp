package com.nkechinnaji.simpleweatherapp.network

import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse
import retrofit2.Response

interface CurrentWeatherService {
    suspend fun getCurrentWeather(accessKey: String, query: String): Response<CurrentWeatherResponse>
}