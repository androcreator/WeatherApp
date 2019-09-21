package com.app.weatherforcast.di.builder

import com.app.weatherforcast.di.module.AppModule
import com.app.weatherforcast.di.module.LiveDataModule
import com.app.weatherforcast.di.module.NetworkModule
import com.app.weatherforcast.di.module.RetrofitModule
import com.app.weatherforcast.view.WeatherInfoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [RetrofitModule::class, NetworkModule::class, LiveDataModule::class])
abstract class Activitybuilder {

    @ContributesAndroidInjector(modules = [AppModule::class])
    internal abstract fun bindWeatherActivity(): WeatherInfoActivity

}