package com.app

import android.app.Activity
import android.app.Application
import com.app.weatherforcast.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AppController : Application(), HasActivityInjector {

    @set:Inject
    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? = activityDispatchingAndroidInjector


    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().application(this).build().inject(this)
    }

}