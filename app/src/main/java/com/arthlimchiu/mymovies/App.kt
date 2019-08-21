package com.arthlimchiu.mymovies

import android.app.Application
import com.arthlimchiu.mymovies.di.AppComponent
import com.arthlimchiu.mymovies.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
            .builder()
            .build()
    }
}

lateinit var component: AppComponent