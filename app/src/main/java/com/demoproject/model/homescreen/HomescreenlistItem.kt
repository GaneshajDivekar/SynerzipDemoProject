package fieldtrak.kotlin.model.homescreen

import com.google.gson.annotations.SerializedName

class HomescreenlistItem {
    @SerializedName("pending_item_count")
    var pendingItemCount = 0

    @SerializedName("app_menu_id")
    var appMenuId = 0

    @SerializedName("menu_order")
    var menuOrder = 0

    @SerializedName("app_version")
    var appVersion: String? = null

    @SerializedName("app_menu_desc")
    var appMenuDesc: String? = null

    @SerializedName("visit_type_icon2_path")
    var visitTypeIcon2Path: String? = null

    @SerializedName("app_menu_code")
    var appMenuCode: String? = null

    @SerializedName("visit_type_icon1_path")
    var visitTypeIcon1Path: String? = null

    @SerializedName("visit_type_icon3_path")
    var visitTypeIcon3Path: String? = null

    @SerializedName("visit_type_icon4_path")
    var visitTypeIcon4Path: String? = null

    @SerializedName("visit_type_icon5_path")
    var visitTypeIcon5Path: String? = null

    @SerializedName("has_more_opt")
    var has_more_opt: String? = null

    @SerializedName("has_submenu")
    var isHasSubmenu = false

    override fun toString(): String {
        return "HomescreenlistItem{" +
                "pending_item_count = '" + pendingItemCount + '\'' +
                ",app_menu_id = '" + appMenuId + '\'' +
                ",menu_order = '" + menuOrder + '\'' +
                ",app_version = '" + appVersion + '\'' +
                ",app_menu_desc = '" + appMenuDesc + '\'' +
                ",visit_type_icon2_path = '" + visitTypeIcon2Path + '\'' +
                ",app_menu_code = '" + appMenuCode + '\'' +
                ",visit_type_icon1_path = '" + visitTypeIcon1Path + '\'' +
                ",visit_type_icon3_path = '" + visitTypeIcon3Path + '\'' +
                ",visit_type_icon4_path = '" + visitTypeIcon4Path + '\'' +
                ",has_more_opt = '" + has_more_opt + '\'' +
                ",has_submenu = '" + isHasSubmenu + '\'' +
                "}"
    }
}