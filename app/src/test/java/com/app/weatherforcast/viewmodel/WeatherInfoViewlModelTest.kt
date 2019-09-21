package com.app.weatherforcast.viewmodel

import com.app.weatherforcast.data.remote.weatherdata.RestCallback
import com.app.weatherforcast.data.remote.weatherdata.response.WeatherResponse
import com.app.weatherforcast.data.repo.WeatherInfoRepo
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class WeatherInfoViewlModelTest {

    var viewModel: WeatherInfoViewlModel? = null

    @Mock
    lateinit var callback : RestCallback<WeatherResponse>

    @Mock
    lateinit var mockrestCallback: RestCallback<WeatherResponse>


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        viewModel = WeatherInfoViewlModel()
    }

    @After
    fun tearDown() {
        viewModel=null
    }

    @Test
    fun WeatherInfoViewlModel_weatherInfo() {
        val mockViewModel = Mockito.mock(WeatherInfoViewlModel::class.java)
        Mockito.doReturn(mockrestCallback).`when`(mockViewModel).weatherInfoCallback()
        val mockRepo = Mockito.mock(WeatherInfoRepo::class.java)
        viewModel!!.weatherInfoRepo=mockRepo
        viewModel!!.weatherInfo()

    }
}