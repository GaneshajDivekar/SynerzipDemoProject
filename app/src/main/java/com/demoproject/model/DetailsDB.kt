package com.demoproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "details_data")
open class DetailsDB {
    @PrimaryKey(autoGenerate = true)
    var detailsId: Long = 0L

    @ColumnInfo(name = "travelType")
    var travelType: String? = null

    @ColumnInfo(name = "travelMode")
    var travelMode: String? = null

    @ColumnInfo(name = "detailsFlag")
    var detailsFlag: String? = null

    @ColumnInfo(name = "strAddress")
    var strAddress: String? = null
    @ColumnInfo(name = "strLastName")
    var strLastName: String? = null
    @ColumnInfo(name = "strSecondName")
    var strSecondName: String? = null
    @ColumnInfo(name = "strFirstName")
    var strFirstName: String? = null
}