package com.demoproject.viewmodel

import android.app.Application
import com.demoproject.application.WeatherApplication
import com.demoproject.di.ApiComponent
import com.demoproject.network.ApiServices
import com.demoproject.repository.LoginRepository
import com.demoproject.repository.PlannedRepo
import com.demoproject.ui.base.BaseViewModel
import retrofit2.Retrofit
import javax.inject.Inject

class PlannedViewModel  (application: Application) :
    BaseViewModel(application) {
    @Inject
    lateinit var retrofit: Retrofit
    lateinit var apiServices: ApiServices
    lateinit var plannedRepo: PlannedRepo

    init {
        val apiComponent: ApiComponent = getApplication<WeatherApplication>().getNetComponent()
        apiComponent.inject(this)
        apiServices = retrofit.create(ApiServices::class.java)
        plannedRepo = PlannedRepo(application, apiServices)
    }

}