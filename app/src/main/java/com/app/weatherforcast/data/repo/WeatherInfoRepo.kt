package com.app.weatherforcast.data.repo

import android.util.Log
import com.app.weatherforcast.data.remote.api.IWeatherApi
import com.app.weatherforcast.data.remote.weatherdata.RestCallback
import com.app.weatherforcast.data.remote.weatherdata.Rx
import com.app.weatherforcast.data.remote.weatherdata.response.WeatherResponse
import javax.inject.Inject

class WeatherInfoRepo @Inject constructor(){
val TAG:String = javaClass.simpleName.toString()

    @Inject
    lateinit var iWeatherApi: IWeatherApi

    @Inject
    lateinit var apiKey:String

    /**
     * Adding Request with RX object to make ASYNC
     */
    fun fetchWeatherinfo(callback : RestCallback<WeatherResponse>){
        Log.i(TAG,"Calling Weather Api....")
        //val realurl = "forecast?access_key=$apiKey&query=New York&forecast_days=5"
        val mock_url = "/mock_result.json"
        Rx<WeatherResponse>().setCallback(callback).setObservable(iWeatherApi.getWeatherApi(mock_url)).excute()
    }


}