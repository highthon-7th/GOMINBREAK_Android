package com.example.gomin.di.module

import com.example.gomin.remote.api.MyPageApi
import com.example.gomin.repository.MyPageRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val myPageModule = module {
    single { get<Retrofit>().create(MyPageApi::class.java) }
    single { MyPageRepository(get()) }
    
}