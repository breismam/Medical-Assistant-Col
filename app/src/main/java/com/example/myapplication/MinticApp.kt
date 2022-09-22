package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.repomodule
import com.example.myapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MinticApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MinticApp)
            modules(repomodule, viewModelModule)
        }
    }
}