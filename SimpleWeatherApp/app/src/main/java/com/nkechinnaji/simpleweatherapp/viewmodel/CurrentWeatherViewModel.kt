package com.nkechinnaji.simpleweatherapp.viewmodel

import com.nkechinnaji.simpleweatherapp.base.BaseViewModel
import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse
import com.nkechinnaji.simpleweatherapp.model.HeadlineNewsResponse
import com.nkechinnaji.simpleweatherapp.network.BaseService

class CurrentWeatherViewModel : BaseViewModel() {

    val service = BaseService().getWeatherApiEndpoints()
    val weatherData = createMutableLiveData<CurrentWeatherResponse>()
    val showData = createMutableLiveData<Boolean>()

    val headlineNewsData = createMutableLiveData<HeadlineNewsResponse>()

    fun fetchWeatherData(accessKey: String, query: String) {
        runSuspendFunction({
            val response = service.getCurrentWeather(accessKey, query)
            if (response.isSuccessful) {
                var currentWeather = response.body()
                currentWeather?.let {
                    weatherData.postValue(it)
                    showData.postValue(true)
                }

            } else {
                showData.postValue(false)
            }

        },
            {
                showData.postValue(false)
            }
        )
    }


    fun fetchTopHealineNews(accessKey: String, query: String){
        runSuspendFunction({
            val response = service.getHeadlineNews(query, accessKey)
            if(response.isSuccessful){
                var news = response.body()
                news?.let {
                    headlineNewsData.postValue(it)
                }
            }
        })
    }


}
