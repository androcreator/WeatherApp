package com.app.weatherforcast.di.module

import com.app.weatherforcast.data.remote.api.IWeatherApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class NetworkModule{


    @Provides
    fun provideWeatherApi(@Named("weather") retrofit: Retrofit): IWeatherApi {
        return retrofit.create(IWeatherApi::class.java)
    }


}
