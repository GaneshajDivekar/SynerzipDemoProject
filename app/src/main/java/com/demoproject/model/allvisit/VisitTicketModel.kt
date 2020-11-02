package com.demoproject.model.allvisit

import com.google.gson.annotations.SerializedName

class VisitTicketModel {
    @SerializedName("flag")
    var flag: String? = null

    @SerializedName("data")
    var data: List<DataItem>? = null

    override fun toString(): String {
        return "VisitTicketModel{" +
                "flag = '" + flag + '\'' +
                ",data = '" + data + '\'' +
                "}"
    }
}