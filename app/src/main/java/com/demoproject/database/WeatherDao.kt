package com.demoproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.demoproject.model.DisplayData
import com.demoproject.model.WeatherResponse

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_data WHERE weatherCity=:city")
    fun loadAllByIds(city: String): DisplayData

    @Insert
    fun insert(vararg users: DisplayData)

    @Query("DELETE FROM weather_data")
    fun delete()
}