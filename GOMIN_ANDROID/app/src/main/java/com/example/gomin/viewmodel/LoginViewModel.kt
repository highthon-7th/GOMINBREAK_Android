package com.example.gomin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.base.SingleLiveEvent
import com.example.gomin.model.LoginEntity
import com.example.gomin.repository.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository): ViewModel() {

    val userId = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    val doneLogin = SingleLiveEvent<Unit>()

    fun login(){
        val request = LoginEntity(userId.value!!, password.value!!)
        loginRepository.login(request).subscribe { result ->
            if(result.isSuccessful) {
                doneLogin.call()
            }
        }
    }
}