package com.example.coronaproject.app

import android.app.Application
import com.example.coronaproject.di.appModule
import com.example.coronaproject.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        //start koin
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, dataModule))
        }
    }

}