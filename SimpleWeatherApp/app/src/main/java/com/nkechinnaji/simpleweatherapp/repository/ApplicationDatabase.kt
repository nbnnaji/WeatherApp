package com.nkechinnaji.simpleweatherapp.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nkechinnaji.simpleweatherapp.model.CurrentWeatherResponse

@Database(entities = [(CurrentWeatherResponse::class)], version = 1)
@TypeConverters(DatabaseTypeConverters::class)
abstract class ApplicationDatabase: RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao
}