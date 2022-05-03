package com.nkechinnaji.simpleweatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nkechinnaji.simpleweatherapp.base.BaseViewModel
import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse
import com.nkechinnaji.simpleweatherapp.network.BaseService
import com.nkechinnaji.simpleweatherapp.network.CurrentWeatherService
import com.nkechinnaji.simpleweatherapp.network.CurrentWeatherServiceImpl
import com.nkechinnaji.simpleweatherapp.repository.CurrentWeatherRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

class CurrentWeatherViewModel : BaseViewModel() {

    val service = BaseService().getEndPointsInterface()
    val weatherData = createMutableLiveData<CurrentWeatherResponse>()
    val showData = createMutableLiveData<Boolean>()

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



}
