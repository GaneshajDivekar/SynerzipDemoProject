package com.demoproject.repository

import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import com.demoproject.database.MyRoomDataBase
import com.demoproject.model.VisitDB
import com.demoproject.network.ApiServices
import javax.inject.Inject

class PlannedDetailsRepo @Inject constructor(
    private val context: Context,
    private var apiServices: ApiServices
) {


}

