package com.demoproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "completed_data")
class CompletedDB {

    @PrimaryKey(autoGenerate = true)
    var completedId: Long = 0L

    @ColumnInfo(name = "uniqueID")
    var uniqueID : String? = null
}