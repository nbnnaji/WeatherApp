package com.nkechinnaji.simpleweatherapp.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.nkechinnaji.simpleweatherapp.base.App
import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse

class RoomRepository : CurrentWeatherRepository {
    private val currentWeatherDao: CurrentWeatherDao = App.database.currentWeatherDao()
    private val allWeatherData: LiveData<CurrentWeatherResponse>

    init {
        allWeatherData = currentWeatherDao.getAllWeatherData()
    }

    private class InsertAsyncTask internal constructor(private val dao: CurrentWeatherDao) :
        AsyncTask<CurrentWeatherResponse, Void, Void>() {
        override fun doInBackground(vararg params: CurrentWeatherResponse?): Void? {
            params[0]?.let { dao.insert(it) }
            return null
        }

        class DeleteAsyncTask internal constructor(private val dao: CurrentWeatherDao) :
            AsyncTask<CurrentWeatherResponse, Void, Void>() {
            override fun doInBackground(vararg params: CurrentWeatherResponse): Void? {
                dao.clearWeatherData(*params)
                return null
            }
        }

    }

    override fun saveCurrentWeather(weatherResponse: CurrentWeatherResponse) {
        InsertAsyncTask(currentWeatherDao).execute(weatherResponse)
    }

    override fun getAllWeatherConditions(): LiveData<CurrentWeatherResponse> {
        return allWeatherData
    }

    override fun clearAllWeatherData() {
        val weatherData = allWeatherData.value
        if (weatherData != null) {
            InsertAsyncTask.DeleteAsyncTask(currentWeatherDao).execute(weatherData)
        }
    }
}