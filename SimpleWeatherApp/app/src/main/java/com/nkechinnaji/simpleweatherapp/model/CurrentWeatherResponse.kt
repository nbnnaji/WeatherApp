package com.nkechinnaji.simpleweatherapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.nkechinnaji.simpleweatherapp.repository.DatabaseTypeConverters

@Entity(tableName = "current_weather_table")

data class CurrentWeatherResponse(
    @TypeConverters(DatabaseTypeConverters::class)
    @SerializedName("request") var request : Request?,

    @TypeConverters(DatabaseTypeConverters::class)
    @SerializedName("location") var location : Location?,

    @TypeConverters(DatabaseTypeConverters::class)
    @SerializedName("current") var current : Current?
){
    @PrimaryKey(autoGenerate = true)
    var weatherId: Int = 0
}

data class Request(
    @SerializedName("type") val type : String,
    @SerializedName("query") val query : String,
    @SerializedName("language") val language : String,
    @SerializedName("unit") val unit : String
)

data class Location(
    @SerializedName("name") val name : String,
    @SerializedName("country") val country : String,
    @SerializedName("region") val region : String,
    @SerializedName("lat") val lat : Double,
    @SerializedName("lon") val lon : Double,
    @SerializedName("timezone_id") val timezone_id : String,
    @SerializedName("localtime") val localtime : String,
    @SerializedName("localtime_epoch") val localtime_epoch : Int,
    @SerializedName("utc_offset") val utc_offset : Double

)

data class Current(
    @SerializedName("observation_time") val observation_time : String,
    @SerializedName("temperature") val temperature : Double,
    @SerializedName("weather_code") val weather_code : Int,
    @SerializedName("weather_icons") val weather_icons : List<String>,
    @SerializedName("weather_descriptions") val weather_descriptions : List<String>,
    @SerializedName("wind_speed") val wind_speed : Int,
    @SerializedName("wind_degree") val wind_degree : Int,
    @SerializedName("wind_dir") val wind_dir : String,
    @SerializedName("pressure") val pressure : Int,
    @SerializedName("precip") val precip : Double,
    @SerializedName("humidity") val humidity : Int,
    @SerializedName("cloudcover") val cloudcover : Int,
    @SerializedName("feelslike") val feelslike : Int,
    @SerializedName("uv_index") val uv_index : Int,
    @SerializedName("visibility") val visibility : Int,
    @SerializedName("is_day") val is_day : String

)

