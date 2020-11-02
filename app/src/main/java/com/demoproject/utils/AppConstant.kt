package com.demoproject.utils

import android.content.Context
import android.text.TextUtils
import android.util.Log
import java.sql.Timestamp
import java.util.*

class AppConstant {

    companion object {
        val BASE_URL: String = "https://fieldtrak.hitachi-payments.com/FieldTrak/API/"
        const val validate="v2/ValidateLogin"
        const val GetHomeScreen ="v1/GetHomeScreen"

        fun iSflusheRequire(context: Context): Boolean {
            if (TextUtils.isEmpty(PrefUtils.getFromPrefs(context, PrefUtils.TIMESTAMP))) {
                PrefUtils.saveToPrefs(
                    context,
                    PrefUtils.TIMESTAMP,
                    "" + System.currentTimeMillis()
                )
                return false
            }
            val date = Date()
            val timestamp1 = Timestamp(System.currentTimeMillis())

            val cal = Calendar.getInstance()
            cal.timeInMillis = timestamp1.getTime()

            // add a bunch of seconds to the calendar

            // add a bunch of seconds to the calendar
            cal.add(Calendar.SECOND, 98765)

            // create a second time stamp

            // create a second time stamp
            val timestamp2 =
                Timestamp(PrefUtils.getFromPrefs(context, PrefUtils.TIMESTAMP)!!.toLong())

            val milliseconds: Long = timestamp1.getTime() - timestamp2.getTime()
            var seconds = milliseconds.toInt() / 1000

            val hours = seconds / 3600
            val minutes = seconds % 3600 / 60
            seconds = seconds % 3600 % 60

            Log.e("hourshours","hoursa:  "+hours)
            return if (hours > 12) true else false
        }
    }


}