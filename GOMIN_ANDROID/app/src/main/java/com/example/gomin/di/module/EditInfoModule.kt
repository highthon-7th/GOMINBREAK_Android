package com.example.gomin.di.module

import com.example.gomin.viewmodel.EditInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val editModule = module {
    viewModel { EditInfoViewModel() }
}