package com.demoproject.application

import android.app.Application
import com.demoproject.database.MyRoomDataBase
import com.demoproject.di.ApiComponent
import com.demoproject.di.ApiModule
import com.demoproject.di.AppModule
import com.demoproject.di.DaggerApiComponent
import com.demoproject.utils.AppConstant

class WeatherApplication : Application() {
    lateinit var mApiComponent: ApiComponent;
    override fun onCreate() {
        super.onCreate()
        mApiComponent = DaggerApiComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule(AppConstant.BASE_URL))
            .build()
    }

    fun getNetComponent(): ApiComponent {
        return mApiComponent
    }
}