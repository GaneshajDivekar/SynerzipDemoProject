package com.demoproject.model.traveltype


import com.google.gson.annotations.SerializedName

data class TravelTypeModel(
    val `data`: List<Data>,
    val flag: String
)