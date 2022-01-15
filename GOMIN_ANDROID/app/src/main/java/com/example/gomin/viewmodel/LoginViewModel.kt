package com.example.gomin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.model.LoginEntity
import com.example.gomin.repository.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository): ViewModel() {

    val userId = MutableLiveData<String>()

    val password =MutableLiveData<String>()

    fun login(name: LoginEntity){
        loginRepository.login(name).subscribe { result ->

        }
    }
}