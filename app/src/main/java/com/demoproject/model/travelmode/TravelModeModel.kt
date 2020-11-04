package com.demoproject.model.travelmode


import com.google.gson.annotations.SerializedName

data class TravelModeModel(
    val `data`: List<Data>,
    val flag: String
)