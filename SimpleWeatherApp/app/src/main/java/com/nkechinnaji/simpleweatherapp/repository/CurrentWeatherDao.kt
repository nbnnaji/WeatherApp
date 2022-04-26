package com.nkechinnaji.simpleweatherapp.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse

@Dao
interface CurrentWeatherDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherResponse: CurrentWeatherResponse)

    @Delete
    fun clearWeatherData(vararg weather: CurrentWeatherResponse)

    @Query("SELECT * FROM current_weather_table")
    fun getAllWeatherData(): LiveData<CurrentWeatherResponse>
}