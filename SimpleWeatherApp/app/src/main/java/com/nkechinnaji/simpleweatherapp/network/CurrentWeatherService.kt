package com.nkechinnaji.simpleweatherapp.network

import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse
import com.nkechinnaji.simpleweatherapp.model.HeadlineNewsResponse
import retrofit2.Response

interface CurrentWeatherService {
    suspend fun getCurrentWeather(accessKey: String, query: String): Response<CurrentWeatherResponse>
    suspend fun getNewsHeadline(query: String, accessKey: String): Response<HeadlineNewsResponse>
}