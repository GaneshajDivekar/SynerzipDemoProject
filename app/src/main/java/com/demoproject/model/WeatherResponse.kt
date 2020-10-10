package com.demoproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
data class WeatherResponse(

    @PrimaryKey(autoGenerate = true)
    var weatherId: Long = 0L,

    @ColumnInfo(name = "weatherCity")
    var weatherCity: String? = null,

    @ColumnInfo(name = "weatherTimestamp")
    var weatherTimestamp: Long,

    @ColumnInfo(name = "visibility")
    @field:SerializedName("visibility")
    val visibility: Int? = null,

    @ColumnInfo(name = "timezone")
    @field:SerializedName("timezone")
    val timezone: Int? = null,

    @TypeConverters(Main::class)
    @ColumnInfo(name = "main")
    @field:SerializedName("main")
    val main: Main? = null,

    @TypeConverters(Clouds::class)
    @ColumnInfo(name = "clouds")
    @field:SerializedName("clouds")
    val clouds: Clouds? = null,

    @TypeConverters(Sys::class)
    @ColumnInfo(name = "sys")
    @field:SerializedName("sys")
    val sys: Sys? = null,

    @ColumnInfo(name = "dt")
    @field:SerializedName("dt")
    val dt: Int? = null,

    @ColumnInfo(name = "coord")
    @field:SerializedName("coord")
    val coord: Coord? = null,

    @ColumnInfo(name = "weather")
    @field:SerializedName("weather")
    val weather: List<WeatherItem?>? = null,

    @ColumnInfo(name = "name")
    @field:SerializedName("name")
    val name: String? = null,

    @ColumnInfo(name = "cod")
    @field:SerializedName("cod")
    val cod: Int? = null,

    @ColumnInfo(name = "id")
    @field:SerializedName("id")
    val id: Int? = null,

    @ColumnInfo(name = "base")
    @field:SerializedName("base")
    val base: String? = null,

    @ColumnInfo(name = "wind")
    @field:SerializedName("wind")
    val wind: Wind? = null
)

data class WeatherItem(

    @field:SerializedName("icon")
    val icon: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("main")
    val main: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)

data class Sys(

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("sunrise")
    val sunrise: Int? = null,

    @field:SerializedName("sunset")
    val sunset: Int? = null
)

data class Main(

    @field:SerializedName("temp")
    val temp: Double? = null,

    @field:SerializedName("temp_min")
    val tempMin: Double? = null,

    @field:SerializedName("grnd_level")
    val grndLevel: Int? = null,

    @field:SerializedName("humidity")
    val humidity: Int? = null,

    @field:SerializedName("pressure")
    val pressure: Int? = null,

    @field:SerializedName("sea_level")
    val seaLevel: Int? = null,

    @field:SerializedName("feels_like")
    val feelsLike: Double? = null,

    @field:SerializedName("temp_max")
    val tempMax: Double? = null
)

data class Coord(

    @field:SerializedName("lon")
    val lon: Double? = null,

    @field:SerializedName("lat")
    val lat: Double? = null
)

data class Wind(

    @field:SerializedName("deg")
    val deg: Int? = null,

    @field:SerializedName("speed")
    val speed: Double? = null
)

data class Clouds(

    @field:SerializedName("all")
    val all: Int? = null
)
