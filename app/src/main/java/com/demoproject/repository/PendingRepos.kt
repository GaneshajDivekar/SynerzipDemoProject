package com.demoproject.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.demoproject.database.MyRoomDataBase
import com.demoproject.model.VisitDB
import com.demoproject.model.WeatherResponse
import com.demoproject.network.ApiServices
import com.google.gson.Gson
import javax.inject.Inject

class PendingRepos @Inject constructor(
    private val context: Context,
    private var apiServices: ApiServices
) {


}


