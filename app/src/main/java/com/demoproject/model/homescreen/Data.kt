package fieldtrak.kotlin.model.homescreen

import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("homescreen_count")
    var homescreenCount = 0

    @SerializedName("homescreenlist")
    var homescreenlist: List<HomescreenlistItem>? = null

    override fun toString(): String {
        return "Data{" +
                "homescreen_count = '" + homescreenCount + '\'' +
                ",homescreenlist = '" + homescreenlist + '\'' +
                "}"
    }
}