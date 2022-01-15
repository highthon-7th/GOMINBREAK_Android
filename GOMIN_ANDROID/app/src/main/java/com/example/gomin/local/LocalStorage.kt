package com.example.gomin.local

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.rxjava3.RxDataStore
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.ExperimentalCoroutinesApi

class LocalStorage(private val dataStore: RxDataStore<Preferences>) {

    companion object {
        private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
        private val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
    }

    @ExperimentalCoroutinesApi
    fun saveAccessToken(token: String) {
        dataStore.updateDataAsync {
            val mutablePreference = it.toMutablePreferences()
            mutablePreference[ACCESS_TOKEN_KEY] = token
            Single.just(mutablePreference)
        }
    }

    @ExperimentalCoroutinesApi
    fun saveRefreshToken(token: String) {
        dataStore.updateDataAsync {
            val mutablePreference = it.toMutablePreferences()
            mutablePreference[REFRESH_TOKEN_KEY] = token
            Single.just(mutablePreference)
        }
    }

    @ExperimentalCoroutinesApi
    fun getAccessToken(): String {
        return dataStore.data().map {
            "Bearer ${it[ACCESS_TOKEN_KEY] ?: ""}"
        }.blockingFirst()
    }

    @ExperimentalCoroutinesApi
    fun getRefreshToken(): String {
        return dataStore.data().map {
            it[REFRESH_TOKEN_KEY] ?: ""
        }.blockingFirst()
    }
}