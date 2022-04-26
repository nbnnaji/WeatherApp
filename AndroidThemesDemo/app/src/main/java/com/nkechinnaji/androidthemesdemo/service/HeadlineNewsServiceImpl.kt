package com.nkechinnaji.androidthemesdemo.service

import com.nkechinnaji.androidthemesdemo.model.TopHeadlines
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceImpl {

    var retrofit: Retrofit= Retrofit.Builder()
        .baseUrl(Endpoints.headlineAPI)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service : ApiService = retrofit.create(ApiService::class.java)
    var callService : Call<TopHeadlines> = service.getHeadlineNews()
}
