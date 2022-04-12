package com.vas.newsapp.di

import com.vas.newsapp.MainActivity
import dagger.Component

@Component(modules = [DataModule::class, DomainModule::class, AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}