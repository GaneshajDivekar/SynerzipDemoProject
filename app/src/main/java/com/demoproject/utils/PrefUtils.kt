package com.demoproject.utils

import android.content.Context
import android.preference.PreferenceManager

class PrefUtils {

    companion object {
        val TIMESTAMP = "timestamp"
        fun saveToPrefs(
            context: Context?,
            key: String?,
            value: String?
        ): String? {
            val prefs = PreferenceManager
                .getDefaultSharedPreferences(context)
            val editor = prefs.edit()
            editor.putString(key, value)
            editor.apply()
            return key
        }

        fun clearData(c: Context?) {
            val prefs = PreferenceManager
                .getDefaultSharedPreferences(c)
            val editor = prefs.edit()
            editor.clear()
            editor.apply()
        }

        fun getFromPrefs(context: Context?, key: String?): String? {
            val sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(context)
            return try {
                sharedPrefs.getString(key, "")
            } catch (e: Exception) {
                e.printStackTrace()
                ""
            }
        }
    }
}