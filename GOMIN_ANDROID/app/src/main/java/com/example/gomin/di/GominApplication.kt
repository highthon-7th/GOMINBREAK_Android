package com.example.gomin.di

import android.app.Application
import com.example.gomin.di.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GominApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GominApplication)
            modules(
                listOf(
                    loginModule,
                    networkModule,
                    mainModule,
                    localModule,
                    myPageModule,
                    rankModule
                )
            )
        }

    }
}