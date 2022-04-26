package com.nkechinnaji.simpleweatherapp.network

import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse
import retrofit2.Response

/***
 * API helper class
 */

class CurrentWeatherServiceImpl(val baseService: BaseService): CurrentWeatherService {
    override suspend fun getCurrentWeather(
        accessKey: String,
        query: String
    ): Response<CurrentWeatherResponse> {
        return baseService.getEndPointsInterface().getCurrentWeather(access_key = accessKey, query = query)
    }
}