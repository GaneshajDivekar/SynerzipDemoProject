package com.demoproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "travel_type")
open class AllTravelTypeDB {

    @PrimaryKey(autoGenerate = true)
    var travelTypeId: Long = 0L

    @ColumnInfo(name = "active")
    var active : String? = null

    @ColumnInfo(name = "typeTravelDescriptions")
    var typeTravelDescriptions: String? = null

    @ColumnInfo(name = "typeTravelid")
    var typeTravelid: Int? = null
}