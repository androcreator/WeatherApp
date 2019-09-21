package com.app.weatherforcast.data.remote.api

import com.app.weatherforcast.data.remote.weatherdata.response.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface IWeatherApi {

    @GET
    fun getWeatherApi(@Url url:String): Observable<WeatherResponse>
}