package com.nkechinnaji.simpleweatherapp.network

import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse
import com.nkechinnaji.simpleweatherapp.model.HeadlineNewsResponse
import retrofit2.Response

/***
 * API helper class
 */

class CurrentWeatherServiceImpl(val baseService: BaseService): CurrentWeatherService {
    override suspend fun getCurrentWeather(
        accessKey: String,
        query: String
    ): Response<CurrentWeatherResponse> {
        return baseService.getWeatherApiEndpoints().getCurrentWeather(access_key = accessKey, query = query)
    }

    override suspend fun getNewsHeadline(
        query: String, accessKey: String
    ): Response<HeadlineNewsResponse> {
        return baseService.getNewsApiEndPoints().getHeadlineNews(access_key = accessKey, query = query)
    }
}