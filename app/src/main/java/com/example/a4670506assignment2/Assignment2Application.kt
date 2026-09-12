package com.example.a4670506assignment2

import android.app.Application
import com.example.a4670506assignment2.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Assignment2Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Assignment2Application)
            modules(appModule)
        }
    }
}