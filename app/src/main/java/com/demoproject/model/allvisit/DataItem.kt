package com.demoproject.model.allvisit

import com.google.gson.annotations.SerializedName

class DataItem {
    @SerializedName("end_date")
    var endDate: String? = null

    @SerializedName("visit_ticket_id")
    var visitTicketId = 0

    @SerializedName("site_lat")
    var siteLat: String? = null

    @SerializedName("visit_ticket_user_frequency_id")
    var visitTicketUserFrequencyId = 0

    @SerializedName("site_desc")
    var siteDesc: String? = null

    @SerializedName("site_long")
    var siteLong: String? = null

    @SerializedName("site_code")
    var siteCode: String? = null

    @SerializedName("bank_desc")
    var bank_desc: String? = null

    @SerializedName("visit_type_desc")
    var visit_type_desc: String? = null

    @SerializedName("has_acceptance")
    var isHasAcceptance = false

    @SerializedName("call_status")
    var callStatus: String? = null

    @SerializedName("site_address")
    var siteAddress: String? = null

    @SerializedName("ticket_no")
    var ticketNo: String? = null

    @SerializedName("site_id")
    var siteId = 0

    @SerializedName("ticket_raised_date")
    var ticketRaisedDate: String? = null

    @SerializedName("last_visited")
    var lastVisited: String? = null

    @SerializedName("visit_category_code")
    var visitCategoryCode: String? = null

    @SerializedName("no_of_visits")
    var noOfVisits = 0

    @SerializedName("start_date")
    var startDate: String? = null

    @SerializedName("checklist_id")
    var checklistid: String? = null

    @SerializedName("remarks")
    var remarks: String? = null

    @SerializedName("is_expense_applicable")
    var is_expense_applicable: String? = null

    @SerializedName("visits_due")
    var visits_due: String? = null

    @SerializedName("last_accepted_date")
    var last_accepted_date: String? = null

    @SerializedName("eta")
    var eta: String? = null

    override fun toString(): String {
        return "DataItem{" +
                "end_date = '" + endDate + '\'' +
                ",visit_ticket_id = '" + visitTicketId + '\'' +
                ",site_lat = '" + siteLat + '\'' +
                ",visit_ticket_user_frequency_id = '" + visitTicketUserFrequencyId + '\'' +
                ",site_desc = '" + siteDesc + '\'' +
                ",site_long = '" + siteLong + '\'' +
                ",site_code = '" + siteCode + '\'' +
                ",has_acceptance = '" + isHasAcceptance + '\'' +
                ",call_status = '" + callStatus + '\'' +
                ",site_address = '" + siteAddress + '\'' +
                ",ticket_no = '" + ticketNo + '\'' +
                ",site_id = '" + siteId + '\'' +
                ",ticket_raised_date = '" + ticketRaisedDate + '\'' +
                ",last_visited = '" + lastVisited + '\'' +
                ",visit_category_code = '" + visitCategoryCode + '\'' +
                ",no_of_visits = '" + noOfVisits + '\'' +
                ",checklist_id = '" + checklistid + '\'' +
                ",remarks = '" + remarks + '\'' +
                ",is_expense_applicable = '" + is_expense_applicable + '\'' +
                ",visits_due = '" + visits_due + '\'' +
                ",start_date = '" + startDate + '\'' +
                "}"
    }
}