package com.demoproject.repository

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.demoproject.database.MyRoomDataBase
import com.demoproject.model.DisplayData
import com.demoproject.model.WeatherResponse
import com.demoproject.network.ApiServices
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class WeatherRepository @Inject constructor(
    private val context: Context,
    private var apiServices: ApiServices
) {

    private val TAG = WeatherRepository::class.java.simpleName

    @SuppressLint("CheckResult")
    fun getWeatherResponse(city: String): MutableLiveData<WeatherResponse> {

        var weatherResponseLiveData = MutableLiveData<WeatherResponse>()

        var displayData = MyRoomDataBase.getInstance(context).getNoteDao()
            .loadAllByIds(city)
        if (displayData != null && displayData.weatherCity.equals(city)) {
            val gson = Gson()
            var data = gson.fromJson(displayData.response, WeatherResponse::class.java);
            data.weatherCity=city
            weatherResponseLiveData.postValue(data)
        } else {
            apiServices.getWeather(city, "2c9834db130ddd3e56154e44988279cc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                    { weather ->
                        Log.e("weather", "$city    " + weather.main!!.temp)
                        var displayData = DisplayData()
                        displayData.weatherCity = city
                        weather.weatherCity=city
                        val gson = Gson()
                        val json = gson.toJson(weather)
                        displayData.response = json
                        MyRoomDataBase.getInstance(context).getNoteDao()!!
                            .insert(displayData)
                        weatherResponseLiveData.postValue(weather)
                    },
                    { error ->
                        weatherResponseLiveData.postValue(null)
                        handledError(error)
                    }

                )
        }

        return weatherResponseLiveData

    }

    private fun handledError(error: Throwable?) {
        Log.e(TAG, "Weather" + error.toString())
    }
}