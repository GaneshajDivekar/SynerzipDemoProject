package com.demoproject.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.demoproject.application.WeatherApplication
import com.demoproject.di.ApiComponent
import com.demoproject.model.VisitDB
import com.demoproject.model.WeatherResponse
import com.demoproject.network.ApiServices
import com.demoproject.repository.PendingRepos
import com.demoproject.ui.base.BaseViewModel
import retrofit2.Retrofit
import javax.inject.Inject

class PendingViewModel (application: Application) :
    BaseViewModel(application) {
    @Inject
    lateinit var retrofit: Retrofit
    lateinit var apiServices: ApiServices
    lateinit var pendingRepos: PendingRepos

    init {
        val apiComponent: ApiComponent = getApplication<WeatherApplication>().getNetComponent()
        apiComponent.inject(this)
        apiServices = retrofit.create(ApiServices::class.java)
        pendingRepos= PendingRepos(application,apiServices)
    }


}