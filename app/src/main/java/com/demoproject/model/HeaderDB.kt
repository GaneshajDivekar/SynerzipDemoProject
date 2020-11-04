package com.demoproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "header_data")
open class HeaderDB {

    @PrimaryKey(autoGenerate = true)
    var headerId: Int = 0

    @ColumnInfo(name = "travelType")
    var travelType: String? = null

    @ColumnInfo(name = "travelMode")
    var travelMode: String? = null

    @ColumnInfo(name = "headerFlag")
    var headerFlag: String? = null

    @ColumnInfo(name = "strAddress")
    var strAddress: String? = null

    @ColumnInfo(name = "strLastName")
    var strLastName: String? = null

    @ColumnInfo(name = "strSecondName")
    var strSecondName: String? = null

    @ColumnInfo(name = "strFirstName")
    var strFirstName: String? = null

}