package com.example.gomin.di.module

import com.example.gomin.remote.api.MyPageApi
import com.example.gomin.repository.MyGominRepository
import com.example.gomin.repository.MyPageRepository
import com.example.gomin.viewmodel.MyGominsViewModel
import com.example.gomin.viewmodel.MyPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val myPageModule = module {

    single { get<Retrofit>().create(MyPageApi::class.java) }
    single { MyPageRepository(get()) }
    viewModel { MyPageViewModel(get()) }

    single { MyGominRepository(get()) }
    viewModel { MyGominsViewModel(get()) }
}