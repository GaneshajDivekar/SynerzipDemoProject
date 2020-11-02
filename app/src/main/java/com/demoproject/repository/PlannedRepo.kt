package com.demoproject.repository

import android.content.Context
import com.demoproject.network.ApiServices
import javax.inject.Inject

class PlannedRepo @Inject constructor(
    private val context: Context,
    private var apiServices: ApiServices
) {

}