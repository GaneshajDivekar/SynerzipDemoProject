package com.demoproject.viewmodel

import android.app.Application
import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import com.demoproject.application.WeatherApplication
import com.demoproject.di.ApiComponent
import com.demoproject.model.VisitDB
import com.demoproject.network.ApiServices
import com.demoproject.repository.LoginRepository
import com.demoproject.repository.PlannedDetailsRepo
import com.demoproject.repository.PlannedRepo
import com.demoproject.ui.base.BaseViewModel
import retrofit2.Retrofit
import javax.inject.Inject

class PlannedDetailsViewModel (application: Application) :
    BaseViewModel(application) {
    @Inject
    lateinit var retrofit: Retrofit
    lateinit var apiServices: ApiServices
    lateinit var plannedDetailsRepo: PlannedDetailsRepo

    var liveDataLogin: LiveData<VisitDB>? = null

    init {
        val apiComponent: ApiComponent = getApplication<WeatherApplication>().getNetComponent()
        apiComponent.inject(this)
        apiServices = retrofit.create(ApiServices::class.java)
        plannedDetailsRepo = PlannedDetailsRepo(application, apiServices)
    }

}