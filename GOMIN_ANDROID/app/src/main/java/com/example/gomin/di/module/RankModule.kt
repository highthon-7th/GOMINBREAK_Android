package com.example.gomin.di.module

import com.example.gomin.viewmodel.RankViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val rankModule = module {
    viewModel { RankViewModel() }
}