package com.nkechinnaji.simpleweatherapp.repository

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nkechinnaji.simpleweatherapp.model.Current
import com.nkechinnaji.simpleweatherapp.model.Location
import com.nkechinnaji.simpleweatherapp.model.Request

class DatabaseTypeConverters {
    val gson: Gson by lazy {
        Gson()
    }
    @TypeConverter
    fun saveRequest(request: Request): String?{
        return gson.let{
            val type = object: TypeToken<Request>() {}.type
            return@let it.toJson(request, type)
        }
    }

    @TypeConverter
    fun toRequest(jsonString: String): Request?{
        return gson.let{
            val type = object: TypeToken<Request>() {}.type
            return@let it.fromJson(jsonString, type)
        }
    }

    @TypeConverter
    fun saveLocation(request: Location): String?{
        return gson.let{
            val type = object: TypeToken<Location>() {}.type
            return@let it.toJson(request, type)
        }
    }

    @TypeConverter
    fun toLocation(jsonString: String): Location?{
        return gson.let{
            val type = object: TypeToken<Location>() {}.type
            return@let it.fromJson(jsonString, type)
        }
    }

    @TypeConverter
    fun saveCurrent(request: Current): String?{
        return gson.let{
            val type = object: TypeToken<Current>() {}.type
            return@let it.toJson(request, type)
        }
    }

    @TypeConverter
    fun toCurrent(jsonString: String): Current?{
        return gson.let{
            val type = object: TypeToken<Current>() {}.type
            return@let it.fromJson(jsonString, type)
        }
    }
}