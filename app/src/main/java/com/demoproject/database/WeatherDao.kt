package com.demoproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.demoproject.model.*

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_data WHERE weatherCity=:city")
    fun loadAllByIds(city: String): DisplayData

    @Query("SELECT * FROM home_data")
    fun loadAllHome(): List<HomeScreenDB>

    @Query("SELECT * FROM visit_data WHERE online=:online")
    fun loadAllVisit(online:String): List<VisitDB>

     @Query("SELECT * FROM travel_type")
    fun loadAllType(): List<AllTravelTypeDB>
    
    @Query("SELECT * FROM travel_typeMode")
    fun loadAllMode(): List<AllTravelModeDB>

    @Insert
    fun insert(vararg users: DisplayData)

    @Insert
    fun insertTravelType(vararg travelTypeDB: AllTravelTypeDB)

    @Insert
    fun insertTravelMode(vararg travelModeDB: AllTravelModeDB)


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

    @Query("SELECT headerId FROM header_data WHERE headerId = (SELECT MAX(headerId) FROM header_data)")
    fun expenseVisitUniqueId(): Int


}