package com.demoproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "travel_typeMode")
open class AllTravelModeDB {

    @PrimaryKey(autoGenerate = true)
    var travelModeId: Long = 0L

    @ColumnInfo(name = "active")
    var mode_of_transport_description : String? = null

}