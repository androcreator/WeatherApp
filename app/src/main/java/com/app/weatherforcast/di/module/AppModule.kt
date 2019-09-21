package com.app.weatherforcast.di.module

import android.app.Application
import android.content.Context
import com.app.weatherforcast.viewmodel.ViewModelFactory
import com.app.weatherforcast.viewmodel.WeatherInfoViewlModel
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: Application): Context = application

    @Provides
    fun provideWeatherInfoViewModelFactory(weatherInfoViewlModel: WeatherInfoViewlModel): ViewModelFactory<WeatherInfoViewlModel> =
            ViewModelFactory(weatherInfoViewlModel)

    @Provides
    fun ProvideApiKey():String = "50fe5f266cd236da23eb6aa0a1ced3c0"

}