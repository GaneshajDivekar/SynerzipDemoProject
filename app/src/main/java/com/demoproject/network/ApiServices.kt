package com.demoproject.network

import com.demoproject.model.WeatherResponse
import com.demoproject.model.allvisit.VisitTicketModel
import fieldtrak.kotlin.model.Example
import fieldtrak.kotlin.model.homescreen.HomeScreenListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiServices {
    @GET("/data/2.5/weather/")
    fun getWeather(
        @Query("q") origin: String,
        @Query("appid") destination: String
    ): Observable<WeatherResponse>

    @POST("v2/ValidateLogin")
    fun getValidateLogin(
        @Query("user_name")username: String,
        @Query("password")password: String,
        @Query("push_token")s1: String,
        @Query("login_lat")s2: String,
        @Query("login_lng")s3: String,
        @Query("imei1")s4: String,
        @Query("imei2")s5: String,
        @Query("app_version")s6: String,
        @Query("battery_percent")s7: String,
        @Query("device_model")s8: String,
        @Query("is_db_empty")s9: String
    ): Observable<Example>

    @POST("GetHomeScreen")
    fun getHomeSCreen(
        @Query("user_id")userId:String,
        @Query("business_unit_id")businessUnitId:String
        ): Observable<HomeScreenListResponse>

    @POST("v2/GetAllVisits")
    fun getAllVisit(
        @Query("user_id")userId: String,
        @Query("business_unit_id")businessUnitId: String): Observable<VisitTicketModel>


}