package com.example.gomin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.model.MyInfoEntity
import com.example.gomin.repository.MyPageRepository

class MyPageViewModel(private val myPageRepository: MyPageRepository) : ViewModel() {

    private val _myPageInfo = MutableLiveData<MyInfoEntity>()
    val myPageInfo: LiveData<MyInfoEntity> = _myPageInfo


    fun getMyPageInfo() {
        myPageRepository.getMyPageInfo().subscribe { response ->
            if (response.isSuccessful) {
                _myPageInfo.value = response.body()!!
            }
        }
    }
}