package com.demoproject.model.travelmode


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_rate_applicable")
    val isRateApplicable: Boolean,
    @SerializedName("mode_of_transport_description")
    val modeOfTransportDescription: String,
    @SerializedName("mode_of_transport_id")
    val modeOfTransportId: Int,
    @SerializedName("rate_of_transport")
    val rateOfTransport: Int
)