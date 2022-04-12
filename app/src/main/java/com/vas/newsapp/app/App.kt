package com.vas.newsapp.app

import android.app.Application
import com.vas.newsapp.di.AppComponent
import com.vas.newsapp.di.DaggerAppComponent

class App : Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}