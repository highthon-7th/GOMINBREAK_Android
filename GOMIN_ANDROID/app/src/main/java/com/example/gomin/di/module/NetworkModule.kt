package com.example.gomin.di.module

import android.util.Log
import com.example.gomin.intercepter.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        HttpLoggingInterceptor { message ->
            Log.v(
                "HTTP",
                message
            )
        }.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    single { TokenInterceptor(get()) }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<TokenInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("http://3.34.194.18:8080")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}