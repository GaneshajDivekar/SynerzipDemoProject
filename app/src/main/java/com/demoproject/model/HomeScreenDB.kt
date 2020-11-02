package com.demoproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "home_data")
class HomeScreenDB {

    @PrimaryKey(autoGenerate = true)
    var homeScreenId: Long = 0L

    @ColumnInfo(name = "app_menu_id")
    var app_menu_id: String? = null
    @ColumnInfo(name = "pending_item_count")
    var pending_item_count: String? = null
    @ColumnInfo(name = "menu_order")
    var menu_order: String? = null
    @ColumnInfo(name = "app_menu_desc")
    var app_menu_desc: String? = null
    @ColumnInfo(name = "app_menu_code")
    var app_menu_code: String? = null
    @ColumnInfo(name = "has_submenu")
    var has_submenu: String? = null

}