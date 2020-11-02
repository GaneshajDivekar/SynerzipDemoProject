package fieldtrak.kotlin.model.homescreen

import com.google.gson.annotations.SerializedName

class HomeScreenListResponse {
    @SerializedName("flag")
    var flag: String? = null

    @SerializedName("data")
    var data: Data? = null

    override fun toString(): String {
        return "HomeScreenListResponse{" +
                "flag = '" + flag + '\'' +
                ",data = '" + data + '\'' +
                "}"
    }
}