package com.demoproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "visit_data")
class VisitDB {

    @ColumnInfo(name = "siteDesc")
    var siteDesc: String? = null

    @ColumnInfo(name = "online")
    var online: String? = null


    @ColumnInfo(name = "siteCode")
    var siteCode: String? = null

    @ColumnInfo(name = "bank_desc")
    var bank_desc: String? = null

    @ColumnInfo(name = "visit_type_desc")
    var visit_type_desc: String? = null

    @ColumnInfo(name = "callStatus")
    var callStatus: String? = null

    @ColumnInfo(name = "siteAddress")
    var siteAddress: String? = null

    @ColumnInfo(name = "ticketNo")
    var ticketNo: String? = null

    @ColumnInfo(name = "siteId")
    var siteId: String? = null

    @ColumnInfo(name = "ticketRaisedDate")
    var ticketRaisedDate: String? = null

    @ColumnInfo(name = "lastVisited")
    var lastVisited: String? = null


    @ColumnInfo(name = "visitCategoryCode")
    var visitCategoryCode: String? = null

    @ColumnInfo(name = "noOfVisits")
    var noOfVisits: String? = null

    @ColumnInfo(name = "startDate")
    var startDate: String? = null


    @ColumnInfo(name = "remarks")
    var remarks: String? = null

    @PrimaryKey(autoGenerate = true)
    var visitId: Long = 0L


}