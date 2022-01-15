package com.example.gomin.di.module

import com.example.gomin.repository.MainRepository
import com.example.gomin.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single { MainRepository(get(), get()) }
    viewModel { MainViewModel(get()) }
}