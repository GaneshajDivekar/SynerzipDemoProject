package com.demoproject.model.traveltype


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("type_travel_description")
    val typeTravelDescription: String,
    @SerializedName("type_travel_id")
    val typeTravelId: Int
)