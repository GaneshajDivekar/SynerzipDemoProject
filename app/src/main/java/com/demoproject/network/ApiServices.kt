package com.demoproject.network

import com.demoproject.model.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("/data/2.5/weather/")
    fun getWeather(
        @Query("q") origin: String,
        @Query("appid") destination: String
    ): Observable<WeatherResponse>

}