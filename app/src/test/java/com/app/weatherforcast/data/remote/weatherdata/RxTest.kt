package com.app.weatherforcast.data.remote.weatherdata

import com.app.weatherforcast.data.remote.api.IWeatherApi
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RxTest {

    lateinit var rx: Rx<Any>

    @Mock
    lateinit var iWeatherApi: IWeatherApi

    @Mock
    lateinit var callback : RestCallback<Any>

    @Before
    fun setUp() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler{ Schedulers.trampoline()}

        MockitoAnnotations.initMocks(this)
        rx = Rx()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun Rx_setObservable(){
        val anyRespone = Mockito.mock<Any>(Any::class.java)
        val observable = Observable.just<Any>(anyRespone)
        rx.excute()
        rx.setCallback(callback)
        rx.setObservable(observable)
        assertEquals(rx.setObservable(observable),rx)
    }
}