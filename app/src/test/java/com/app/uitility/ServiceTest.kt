package com.app.uitility

import com.app.weatherforcast.data.remote.api.IWeatherApi
import com.app.weatherforcast.data.remote.weatherdata.response.WeatherResponse
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import junit.framework.TestCase
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class ServiceTest {

    lateinit var mockWebServer:MockWebServer

    lateinit var iWeatherApi: IWeatherApi

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        mockWebServer =MockWebServer()
        mockWebServer.start()



        iWeatherApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(IWeatherApi::class.java)

    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()

    }

    @Test
    fun weatherApiTest(){
        val testObserver =TestObserver<WeatherResponse>()
        val observable  = iWeatherApi.getWeatherApi("mockData")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(testObserver)

        val request = mockWebServer.takeRequest()
        TestCase.assertEquals(request.path, "/mockData")
        testObserver.assertNoErrors()
    }




}