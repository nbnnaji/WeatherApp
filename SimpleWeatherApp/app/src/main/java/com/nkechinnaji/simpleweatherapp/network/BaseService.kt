package com.nkechinnaji.simpleweatherapp.network

import retrofit2.Retrofit
import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory


/***
 * Base service class to be used for
 * all service layers regardless of API types.
 */
class BaseService() {

    fun getWeatherApiEndpoints(): ApiInterface{
        val client = getInterceptor()

        return Retrofit.Builder()
            .baseUrl("http://api.weatherstack.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }

    fun getNewsApiEndPoints(): ApiInterface{
        val client = getInterceptor()

        return Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }

    private fun getInterceptor(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return client
    }
}