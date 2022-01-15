package com.example.gomin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.dto.GominDetail
import com.example.gomin.repository.GominRepository

class GominViewModel(private val gominRepository: GominRepository) : ViewModel() {

    private val gominId : String = ""

    private val _gominDetailContent = MutableLiveData<GominDetail>()
    val gominDetailContent :  LiveData<GominDetail> get() =  _gominDetailContent


    private val _gominListObject = MutableLiveData<List<String>>()
    val gominListObject :  LiveData<List<String>> get() = _gominListObject

    fun getGominList() {
        gominRepository.showGominList().subscribe { it ->
            if (it.isSuccessful) {
                _gominListObject.value = listOf(it.body().toString())
            }
        }
    }

    fun getGominDetail() {
        gominRepository.showGominListDetail(gominId).subscribe { it ->
            if (it.isSuccessful) {
                _gominDetailContent.value = it.body()

            }
        }
    }

}