package com.app.weatherforcast.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.weatherforcast.data.remote.weatherdata.RestCallback
import com.app.weatherforcast.data.remote.weatherdata.response.WeatherResponse
import com.app.weatherforcast.data.repo.WeatherInfoRepo
import javax.inject.Inject

open class WeatherInfoViewlModel @Inject constructor() : ViewModel() {
    val TAG:String = javaClass.simpleName.toString()
    @Inject
    lateinit var weatherInfoRepo: WeatherInfoRepo

    @Inject
    lateinit var weatherLiveData: MutableLiveData<WeatherResponse>


    fun weatherInfoCallback(): RestCallback<WeatherResponse> {
        return  object : RestCallback<WeatherResponse> {
            override fun onsuccess(t: WeatherResponse) {
                Log.i(TAG,"Success Response= ${t.forecastday.toString()}")
                weatherLiveData.postValue(t)
            }

            override fun onfailure() {
                Log.i(TAG,"HANDLE LIVE DATA ERROR")
            }
        }
    }


    /**
     * Call to WEATHER API
     */
    fun weatherInfo(){
        weatherInfoRepo.fetchWeatherinfo(weatherInfoCallback())
    }

}