package com.example.gomin.di

import android.app.Application
import com.example.gomin.di.module.loginModule
import com.example.gomin.di.module.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class GominApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GominApplication)
            module {
                listOf(
                    loginModule,
                    networkModule
                )
            }
        }
    }
}