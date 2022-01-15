package com.example.gomin.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gomin.repository.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository): ViewModel() {
    fun searchSchool(name: String){
        loginRepository.searchSchool(name).subscribe { result ->

        }
    }
}