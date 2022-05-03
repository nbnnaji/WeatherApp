package com.nkechinnaji.simpleweatherapp.base

import android.app.Application
import androidx.room.Room
import com.nkechinnaji.simpleweatherapp.repository.ApplicationDatabase

class App: Application() {
    companion object{
        lateinit var database: ApplicationDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, ApplicationDatabase::class.java, "current_weather_table").build()
    }
}
//African kids: Photo by <a href="https://unsplash.com/@hcmorr?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Hanna Morris</a> on <a href="https://unsplash.com/s/photos/hunger?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>

//Globe: Photo by <a href="https://unsplash.com/@jameswiseman?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">James Wiseman</a> on <a href="https://unsplash.com/s/photos/africa?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
// Working mom in farm: Photo by <a href="https://unsplash.com/@anniespratt?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Annie Spratt</a> on <a href="https://unsplash.com/s/photos/africa?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
//