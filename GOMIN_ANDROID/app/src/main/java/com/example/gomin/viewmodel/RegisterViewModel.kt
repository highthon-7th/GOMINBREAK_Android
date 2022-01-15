package com.example.gomin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.base.SingleLiveEvent
import com.example.gomin.model.RegisterEntity
import com.example.gomin.repository.LoginRepository

class RegisterViewModel(private val repository: LoginRepository): ViewModel() {
    val userId = MutableLiveData<String>()

    val userName = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    val checkPassword = MutableLiveData<String>()

    val schoolName = MutableLiveData<String>()

    val doneRegister = SingleLiveEvent<Unit>()

    fun register() {
        val request = RegisterEntity(userName.value!!, schoolName.value!!, userId.value!!, password.value!!)
        repository.register(request).subscribe { response ->
            if(response.isSuccessful) {
                doneRegister.call()
            }
        }
    }
}