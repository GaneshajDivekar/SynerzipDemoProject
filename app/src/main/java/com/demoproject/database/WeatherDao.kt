package com.demoproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.demoproject.model.DisplayData
import com.demoproject.model.HomeScreenDB
import com.demoproject.model.VisitDB
import com.demoproject.model.WeatherResponse

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_data WHERE weatherCity=:city")
    fun loadAllByIds(city: String): DisplayData

    @Query("SELECT * FROM home_data")
    fun loadAllHome(): List<HomeScreenDB>

    @Query("SELECT * FROM visit_data WHERE online=:online")
    fun loadAllVisit(online:String): List<VisitDB>

    @Insert
    fun insert(vararg users: DisplayData)


    @Insert
    fun insertHome(vararg homeScreenDB: HomeScreenDB)

    @Insert
    fun insertVisit(vararg visitDB: VisitDB)


    @Query("DELETE FROM weather_data")
    fun delete()
    @Query("DELETE FROM home_data")
    fun deleteHome()

    @Query("DELETE FROM visit_data")
    fun deleteVisit()

}