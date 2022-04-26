package com.nkechinnaji.androidthemesdemo.service

import com.nkechinnaji.androidthemesdemo.model.TopHeadlines
import com.nkechinnaji.androidthemesdemo.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v2/top-headlines")
    fun getHeadlineNews(
        @Query("apiKey") apiKey: String = Constants.API_KEY,
        @Query("country") country: String = Constants.COUNTRY,
        @Query("category") category: String = Constants.CATEGORY
    ): Call<TopHeadlines>
}

//http://newsapi.org/v2/top-headlines?apiKey=84a14bd367b6466894466ebcb9da7612&country=us&category=technology