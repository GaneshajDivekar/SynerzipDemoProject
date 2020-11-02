package com.demoproject.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.demoproject.database.MyRoomDataBase
import com.demoproject.model.DisplayData
import com.demoproject.model.WeatherResponse
import com.demoproject.model.allvisit.VisitTicketModel
import com.demoproject.network.ApiServices
import com.google.gson.Gson
import fieldtrak.kotlin.model.Example
import fieldtrak.kotlin.model.homescreen.HomeScreenListResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val context: Context,
    private var apiServices: ApiServices
) {
    fun getLoginResponse(
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
        var loginRepository = MutableLiveData<Example>()
        apiServices.getValidateLogin(username,password,s1,s2,s3,s4,s5,s6,s7,s8,s9)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                { loginResponse ->
                    Log.e("weather", "$    " + loginResponse.data!!.apiList)
                    loginRepository.postValue(loginResponse)
                },
                { error ->
                    loginRepository.postValue(null)
                    handledErrorr(error)
                }

            )
    return loginRepository
    }

    private fun handledErrorr(error: Throwable?) {
        System.out.println("error"+error?.message)
    }

    private fun handledError(error: Throwable?) {
        System.out.println("error"+error?.message)

    }

    fun getHomeSCreenData(userId: String?, businessUnitId: String?): MutableLiveData<HomeScreenListResponse> {
        var homeRepo=MutableLiveData<HomeScreenListResponse>()
        apiServices.getHomeSCreen(userId.toString(),businessUnitId.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                { loginResponse ->
                    homeRepo.postValue(loginResponse)
                },
                { error ->
                    homeRepo.postValue(null)
                    handledError(error)
                }

            )
        return homeRepo
    }

    fun getAllVisit(userId: String, bussinessID: String): MutableLiveData<VisitTicketModel> {
        var allVisit=MutableLiveData<VisitTicketModel>()

        apiServices.
        getAllVisit(userId.toString(),bussinessID.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                allVisits->
                allVisit.postValue(allVisits)
            },
                {
                    error->
                    allVisit.postValue(null)
                    handledErrorVisit(error)
                })
        return allVisit
    }

    private fun handledErrorVisit(error: Throwable) {
        System.out.println("error Visit"+error.message)
    }

}