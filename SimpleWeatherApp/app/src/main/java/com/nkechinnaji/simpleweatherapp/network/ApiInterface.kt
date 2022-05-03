package com.nkechinnaji.simpleweatherapp.network

import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse
import com.nkechinnaji.simpleweatherapp.model.HeadlineNewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

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


    /***
     * APi for headline news
     */

    @GET("https://newsapi.org/v2/everything")
    suspend fun getHeadlineNews(
        @Query("q") query: String,
        @Query("apiKey") access_key: String

    ): Response<HeadlineNewsResponse>
}