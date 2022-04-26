package com.nkechinnaji.simpleweatherapp.network

import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface
{
    /***
     * Api for current weather
     * @param access_key
     * @param query
     */
    @GET("current")
    suspend fun getCurrentWeather(
        @Query("access_key") access_key: String,
        @Query("query") query: String
    ): Response<CurrentWeatherResponse>
}