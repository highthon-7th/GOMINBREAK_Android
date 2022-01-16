package com.example.gomin.di.module

import com.example.gomin.remote.api.GominApi
import com.example.gomin.repository.GominRepository
import com.example.gomin.viewmodel.GominViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val gominModule = module {
    single { get<Retrofit>().create(GominApi::class.java) }
    single { GominRepository(get()) }
    viewModel { GominViewModel(get()) }
}