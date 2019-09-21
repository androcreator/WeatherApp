package com.app.weatherforcast.di.module

import androidx.lifecycle.MutableLiveData
import com.app.weatherforcast.data.remote.weatherdata.response.WeatherResponse
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LiveDataModule {


    @Provides
    @Singleton
    fun provideWeatherLiveData(): MutableLiveData<WeatherResponse> = MutableLiveData()

}