package com.example.gomin.viewmodel

import com.example.gomin.repository.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository) {
    fun searchSchool(name: String){
        loginRepository.searchSchool(name).subscribe { result ->

        }
    }
}