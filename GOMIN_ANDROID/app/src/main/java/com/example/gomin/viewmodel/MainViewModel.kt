package com.example.gomin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.base.SingleLiveEvent
import com.example.gomin.repository.MainRepository

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val _startLogin = SingleLiveEvent<Unit>()
    val startLogin: LiveData<Unit> = _startLogin

    init {
        refreshToken()
    }

    private fun refreshToken() {
        mainRepository.refreshToken().subscribe { response ->
            if(!response.isSuccessful) {
                _startLogin.call()
            }
        }
    }
}