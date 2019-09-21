package com.app.weatherforcast.di.component

import android.app.Application
import com.app.AppController
import com.app.weatherforcast.di.builder.Activitybuilder
import com.app.weatherforcast.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, AppModule::class, Activitybuilder::class))
interface AppComponent {
    fun inject(app: AppController)


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}