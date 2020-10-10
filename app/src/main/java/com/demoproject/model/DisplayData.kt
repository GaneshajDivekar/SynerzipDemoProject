package com.demoproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_data")
open class DisplayData {
    @PrimaryKey(autoGenerate = true)
    var weatherId: Long = 0L

    @ColumnInfo(name = "weatherCity")
    var weatherCity: String? = null

    @ColumnInfo(name = "response")
    var response: String? = null


}