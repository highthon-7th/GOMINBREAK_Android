package com.example.gomin.di.module

import com.example.gomin.remote.api.LoginApi
import com.example.gomin.repository.LoginRepository
import com.example.gomin.viewmodel.LoginViewModel
import com.example.gomin.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val loginModule = module {
    single<LoginApi> { get<Retrofit>().create(LoginApi::class.java) }
    single { LoginRepository(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
}