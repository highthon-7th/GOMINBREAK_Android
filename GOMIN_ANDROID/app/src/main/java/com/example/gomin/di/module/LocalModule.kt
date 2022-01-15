package com.example.gomin.di.module

import androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder
import com.example.gomin.local.LocalStorage
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { RxPreferenceDataStoreBuilder(androidContext(), "gomin").build() }
    single { LocalStorage(get()) }
}