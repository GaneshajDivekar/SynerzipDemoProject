package com.demoproject.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.demoproject.application.WeatherApplication
import com.demoproject.di.ApiComponent
import com.demoproject.model.DisplayData
import com.demoproject.model.WeatherResponse
import com.demoproject.network.ApiServices
import com.demoproject.repository.WeatherRepository
import com.demoproject.ui.base.BaseViewModel
import retrofit2.Retrofit
import javax.inject.Inject

class MainViewModel(application: Application) :
    BaseViewModel(application) {
    @Inject
    lateinit var retrofit: Retrofit
    lateinit var apiServices: ApiServices
    lateinit var weatherRepository: WeatherRepository

    init {
        val apiComponent: ApiComponent = getApplication<WeatherApplication>().getNetComponent()
        apiComponent.inject(this)
        apiServices = retrofit.create(ApiServices::class.java)
        weatherRepository = WeatherRepository(application, apiServices)
    }


    fun getWeatherData(city: String): MutableLiveData<WeatherResponse> {
        return weatherRepository.getWeatherResponse(city)
    }

}