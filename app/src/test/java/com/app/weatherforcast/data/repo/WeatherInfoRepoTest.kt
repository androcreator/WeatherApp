package com.app.weatherforcast.data.repo

import com.app.weatherforcast.data.remote.api.IWeatherApi
import com.app.weatherforcast.data.remote.weatherdata.RestCallback
import com.app.weatherforcast.data.remote.weatherdata.response.WeatherResponse
import io.reactivex.Observable
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WeatherInfoRepoTest {
    var repo: WeatherInfoRepo? =null

    @Mock
    lateinit var mockWeatherApi: IWeatherApi

    @Mock
    lateinit var callback : RestCallback<WeatherResponse>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
         repo = WeatherInfoRepo()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun WeatherInfoRepo_fetchWeatherinfo(){
        val iWeatherApi = Retrofit.Builder()
            .baseUrl("https://localhost.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(IWeatherApi::class.java)

        val anyRespone = Mockito.mock<WeatherResponse>(WeatherResponse::class.java)
        val observable = Observable.just<WeatherResponse>(anyRespone)
        repo!!.iWeatherApi = iWeatherApi
        Mockito.`when`(mockWeatherApi.getWeatherApi("https://localhost.com")).thenReturn(observable)
        repo!!.fetchWeatherinfo(callback)



    }
}