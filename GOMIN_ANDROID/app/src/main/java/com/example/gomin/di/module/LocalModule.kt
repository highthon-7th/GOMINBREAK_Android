package com.example.gomin.di.module

import com.example.gomin.local.LocalStorage
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { LocalStorage(androidContext()) }
}