package com.demoproject.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.demoproject.application.WeatherApplication
import com.demoproject.di.ApiComponent
import com.demoproject.model.WeatherResponse
import com.demoproject.model.allvisit.VisitTicketModel
import com.demoproject.model.travelmode.TravelModeModel
import com.demoproject.model.traveltype.TravelTypeModel
import com.demoproject.network.ApiServices
import com.demoproject.repository.LoginRepository
import com.demoproject.ui.base.BaseViewModel
import fieldtrak.kotlin.model.Example
import fieldtrak.kotlin.model.homescreen.HomeScreenListResponse
import retrofit2.Retrofit
import javax.inject.Inject

class LoginViewModel (application: Application) :
    BaseViewModel(application)  {
    @Inject
    lateinit var retrofit: Retrofit
    lateinit var apiServices: ApiServices
    lateinit var loginRepository: LoginRepository

    init {
        val apiComponent: ApiComponent = getApplication<WeatherApplication>().getNetComponent()
        apiComponent.inject(this)
        apiServices = retrofit.create(ApiServices::class.java)
        loginRepository = LoginRepository(application, apiServices)
    }


    fun validateLogin(
        username: String,
        password: String,
        s1: String,
        s2: String,
        s3: String,
        s4: String,
        s5: String,
        s6: String,
        s7: String,
        s8: String,
        s9: String
    ): MutableLiveData<Example> {
        return loginRepository.getLoginResponse(username,password,s1,s2,s3,s4,s5,s6,s7,s8,s9)
    }

    fun getHomeScreen(userId: String?, businessUnitId: String?): MutableLiveData<HomeScreenListResponse> {
        return loginRepository.getHomeSCreenData(userId,businessUnitId)
    }

    fun getAllVisit(userID: Int, companyId: Int): MutableLiveData<VisitTicketModel> {
        return loginRepository.getAllVisit(userID.toString(),companyId.toString())
    }
    fun getAllTravelTypes(userID: Int): MutableLiveData<TravelTypeModel> {
        return loginRepository.getgetAllTravelTypes(userID.toString())
    }

    fun getAllModesOfTransport(userID: Int): MutableLiveData<TravelModeModel> {
        return loginRepository.getAllModesOfTransport(userID.toString())
    }

}